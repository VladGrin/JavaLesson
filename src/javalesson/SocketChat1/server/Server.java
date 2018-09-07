package javalesson.SocketChat1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 4444;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        new Server();
    }

    private Server() {
        Socket clientSocket = null;
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Сервер запущен!");
            while (true) {
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                new Thread(client).start();
            }
        }
        catch (IOException e) {
            e.getMessage();
        }
        finally {
            try {
                clientSocket.close();
                System.out.println("Сервер остановлен");
            }
            catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public void sendMessageToAllClients(String msg) {
        for (ClientHandler client : clients) {
            client.sendMsg(msg);
        }

    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

}
