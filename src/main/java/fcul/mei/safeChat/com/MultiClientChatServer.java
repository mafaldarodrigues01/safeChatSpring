package fcul.mei.safeChat.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MultiClientChatServer {
    private static List<PrintWriter> clientWriters = new ArrayList<>();
    private static Map<String, List<ClientHandler>> groupClients = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor aguardando conexões...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado.");

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void addClientWriter(PrintWriter writer) {
        clientWriters.add(writer);
    }

    public static synchronized void removeClientWriter(PrintWriter writer) {
        clientWriters.remove(writer);
    }

    public static synchronized void broadcastMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }

    public static void addClientToGroup(String groupName, ClientHandler clientHandler) {
        groupClients.computeIfAbsent(groupName, k -> new ArrayList<>()).add(clientHandler);
        broadcastMessageToGroup(groupName, "Cliente entrou no grupo: " + groupName);
    }

    public static void removeClientFromGroup(String groupName, ClientHandler clientHandler) {
        groupClients.get(groupName).remove(clientHandler);
        broadcastMessageToGroup(groupName, "Cliente saiu do grupo: " + groupName);
    }

    public static void broadcastMessageToGroup(String groupName, String message) {
        for (ClientHandler client : groupClients.get(groupName)) {
            client.sendMessage(message);
        }
    }
}
