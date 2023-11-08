package fcul.mei.safeChat.com;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private PrintWriter writer;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(clientSocket.getInputStream());
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            MultiClientChatServer.addClientWriter(writer);

            while (true) {
                if (scanner.hasNextLine()) {
                    String clientMessage = scanner.nextLine();
                    System.out.println(clientMessage);

                    MultiClientChatServer.broadcastMessage(clientMessage);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MultiClientChatServer.removeClientWriter(writer);
        }
    }
}
