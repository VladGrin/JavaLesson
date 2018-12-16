package javalesson.SocketChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("ServerResp running...");

        try (ServerSocket serverSocket = new ServerSocket(4444);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

            System.out.println(socket.getInetAddress());
            String message = "";
            while (true){
                if(in.ready()) {
                    System.out.println("ServerResp get message");
                    message = in.readLine();
                    System.out.println(message);

                    out.write("Сервер получил сообщение: " + message + "\n");
                    out.flush();
                    Thread.sleep(100);
                }
            }


        } catch (IOException e) {
            e.getMessage();
        }
    }
}
