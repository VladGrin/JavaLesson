package javalesson.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketExClientSide {
    public static void main(String[] args) {
        try(Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),8189), 2000);//localhost

            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
