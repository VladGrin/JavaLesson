package javalesson.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketsClientSide {
    public static void main(String[] args) {
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("india.colorado.edu", 13), 2000);

            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
