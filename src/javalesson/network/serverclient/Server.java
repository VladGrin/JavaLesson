package javalesson.network.serverclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        try (ServerSocket server = new ServerSocket(3345)) {
            Socket socket = server.accept();
            System.out.println("Connection accepted.");
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("DataOutputStream created");
            Scanner scanner = new Scanner(socket.getInputStream());
            System.out.println("DataInputStream created");

            while (scanner.hasNextLine()) {
                System.out.println("Server reading from channel");
                String entry = scanner.nextLine();
                System.out.println("READ from client message - " + entry);
                System.out.println("Server try writing to channel");
                if (entry.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    printWriter.println("Server reply - " + entry + " - OK");
                    printWriter.flush();
                    Thread.sleep(1000);
                    break;
                }
                printWriter.println("Server reply - " + entry + " - OK");
                System.out.println("Server Wrote message to client.");
                printWriter.flush();

            }
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");
            scanner.close();
            printWriter.close();
            socket.close();
            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
