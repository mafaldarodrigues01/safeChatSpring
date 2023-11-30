package fcul.mei.safeChat.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private PrintWriter writer;
    private String groupName;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(clientSocket.getInputStream());
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Solicitar o nome do grupo ao cliente
            groupName = askForGroupName();
            System.out.println("Cliente " + clientSocket.getInetAddress() + " entrou no grupo '" + groupName + "'");

            // Adicionar o ClientHandler ao grupo
            MultiClientChatServer.addClientToGroup(groupName, this);

            while (true) {
                if (scanner.hasNextLine()) {
                    String clientMessage = scanner.nextLine();
                    System.out.println("Cliente " + clientSocket.getInetAddress() + ": " + clientMessage);

                    // Enviar a mensagem para todos no grupo
                    MultiClientChatServer.broadcastMessageToGroup(groupName, clientMessage);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Remover o ClientHandler do grupo ao encerrar
            MultiClientChatServer.removeClientFromGroup(groupName, this);
        }
    }

    private String askForGroupName() throws IOException {
        writer.println("Bem-vindo ao chat! Por favor, digite o nome do grupo que deseja entrar:");
        return new Scanner(clientSocket.getInputStream()).nextLine();
    }


    public void sendMessage(String message) {
        writer.println(message);
    }
    public static void main(String[] args) {
        try {
            // Crie um Socket para se conectar ao servidor
            Socket socket = new Socket("localhost", 5000);

            // Inicie a instância de ClientHandler com o Socket
            ClientHandler clientHandler = new ClientHandler(socket);

            // Inicie a thread para lidar com o cliente
            Thread clientThread = new Thread(clientHandler);
            clientThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
