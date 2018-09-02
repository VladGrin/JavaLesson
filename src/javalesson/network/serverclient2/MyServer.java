package javalesson.network.serverclient2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer  {
    private ArrayList<Connection> connections = new ArrayList<>();

    public static void main(String[] args) {
        new MyServer();
    }

    private MyServer() {
        System.out.println("Server running...");
        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Connection(this, socket);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void sendToAllConnections(String value) {
        System.out.println(value);
        for (int i = 0; i < connections.size(); i++) {
            connections.get(i).sendString(value);
        }
    }

    public void connectionReady(Connection connection) {
        connections.add(connection);
        sendToAllConnections("Client connected: " + connection);
    }

    public void resieveMessage(Connection connection, String value) {
        sendToAllConnections(value);
    }

    public void disconnect(Connection connection) {
        connections.remove(connection);
        sendToAllConnections("Client disconnected: " + connection);
    }

    public void exception(Connection connection, Exception e) {
        System.out.println("Connection exception: " + e);
    }
}

class Connection {
    private Socket socket;
    private Thread thread;
    private BufferedReader in;
    private BufferedWriter out;
    private MyServer connectionEvent;

    public Connection(MyServer connectionEvent, Socket socket) throws IOException {
        this.connectionEvent = connectionEvent;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        thread = new Thread(() -> {
            try {
                connectionEvent.connectionReady(Connection.this);
                while (!thread.isInterrupted()) {
                    String message = in.readLine();
                    connectionEvent.resieveMessage(Connection.this, message);
                }
            } catch (IOException e) {
                connectionEvent.exception(Connection.this, e);
            } finally {
                connectionEvent.disconnect(Connection.this);
            }
        });
        thread.start();
    }

    public synchronized void sendString(String value) {
        try {
            out.write(value + "\r\n");
            out.flush();
        } catch (IOException e) {
            connectionEvent.exception(Connection.this, e);
            disconnect();
        }
    }

    public synchronized void disconnect() {
        thread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            connectionEvent.exception(Connection.this, e);
        }
    }

    @Override
    public String toString() {
        return "Connection: " + socket.getInetAddress() + ": " + socket.getPort();
    }
}
