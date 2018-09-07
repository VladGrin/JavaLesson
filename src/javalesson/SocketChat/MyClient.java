package javalesson.SocketChat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    private static final String IP = "localhost";
    private static final int PORT = 4444;

    public static void main(String[] args) {

        System.out.println("Client connected...");

        try (Socket socket = new Socket(IP, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            out.write(name + " connected\n");
            out.flush();
            System.out.println(in.readLine());
            while (true) {
                System.out.println("Введите сообщение: ");
                out.write(name + ": " + scanner.nextLine() + "\n");
                out.flush();

                String response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
