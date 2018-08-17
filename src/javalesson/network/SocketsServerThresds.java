package javalesson.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketsServerThresds {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new MyServer(socket)).start();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
class MyServer implements Runnable{
    Socket socket;

    public MyServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(Scanner scanner = new Scanner(socket.getInputStream())) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            if (scanner.hasNextLine()){
                printWriter.println("\nYou've send : " + scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
