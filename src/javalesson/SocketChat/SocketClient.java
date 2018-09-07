package javalesson.SocketChat;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    private static BufferedReader reader;

    public static void main(String[] args) {
        try(Socket clientSocket = new Socket("localhost",4444);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));){

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Вы что-то хотели сказать? Введите это здесь:");
            String word = reader.readLine();
            out.write(word + "\n");
            out.flush();
            String serverWord = in.readLine();
            System.out.println(serverWord);
            System.out.println("Клиент был закрыт...");

        }catch (IOException e){
            System.err.println(e);
        }
    }
}
