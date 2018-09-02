package javalesson.network.serverclient1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements ActionListener, ClientConnectionEvent {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyClient());
    }

    private JTextArea log = new JTextArea();
    private JTextField fieldNickName = new JTextField("Vlad");
    private JTextField fieldInput = new JTextField();
    private ClientConnection clientConnection;

    private MyClient(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 600);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        log.setEditable(false);
        log.setLineWrap(true);
        add(log, BorderLayout.CENTER);

        fieldInput.addActionListener(this);
        add(fieldInput, BorderLayout.SOUTH);
        add(fieldNickName, BorderLayout.NORTH);

        setVisible(true);
        try {
            clientConnection = new ClientConnection(this, "192.168.0.10", 4444);
        } catch (IOException e) {
            printMessage("Connection exception: " + e);
        }
    }

    @Override
    public void connectionReady(ClientConnection connection) {
        printMessage("Connection is ready...");
    }

    @Override
    public void resieveMessage(String value) {
        printMessage(value);
    }

    @Override
    public void disconnect(ClientConnection connection) {
        printMessage("Connection close");
    }

    @Override
    public void exception(ClientConnection connection, Exception e) {
        printMessage("Connection exception: " + e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if(msg.equals("")){
            return;
        } else {
            fieldInput.setText(null);
            clientConnection.sendString(fieldNickName.getText() + ": " + msg);
        }
    }

    private synchronized void printMessage(String msg){
        SwingUtilities.invokeLater(() -> {
            log.append(msg + "\n");
            log.setCaretPosition(log.getDocument().getLength());
        });
    }
}
class ClientConnection {
    private Socket socket;
    private Thread thread;
    private BufferedReader in;
    private BufferedWriter out;
    private ClientConnectionEvent connectionEvent;

    public ClientConnection(ClientConnectionEvent connectionEvent, String IpAdr, int port) throws IOException {
        this.connectionEvent = connectionEvent;
        this.socket = new Socket(IpAdr, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        thread = new Thread(() -> {
            try {
                connectionEvent.connectionReady(ClientConnection.this);
                while (!thread.isInterrupted()) {
                    String message = in.readLine();
                    connectionEvent.resieveMessage(message);
                }
            } catch (IOException e) {
                connectionEvent.exception(ClientConnection.this, e);
            } finally {
                connectionEvent.disconnect(ClientConnection.this);
            }
        });
        thread.start();
    }

    public synchronized void sendString(String value) {
        try {
            out.write(value + "\r\n");
            out.flush();
        } catch (IOException e) {
            connectionEvent.exception(ClientConnection.this, e);
            disconnect();
        }
    }

    public synchronized void disconnect() {
        thread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            connectionEvent.exception(ClientConnection.this, e);
        }
    }

    @Override
    public String toString() {
        return "Connection: " + socket.getInetAddress() + ": " + socket.getPort();
    }
}

interface ClientConnectionEvent {
    void connectionReady(ClientConnection connection);

    void resieveMessage(String value);

    void disconnect(ClientConnection connection);

    void exception(ClientConnection connection, Exception e);
}