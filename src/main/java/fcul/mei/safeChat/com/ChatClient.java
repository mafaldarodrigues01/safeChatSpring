package fcul.mei.safeChat.com;

import fcul.mei.safeChat.dao.GroupRepository;
import fcul.mei.safeChat.dao.UserRepository;
import fcul.mei.safeChat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

@Service
public class ChatClient {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;


    public void addNewClientClient() {
        ChatClient chatClient = new ChatClient();
        System.out.println("Whats your name?");
        Scanner name = new Scanner(System.in);
        System.out.println("Whats your name?");
        Scanner password = new Scanner(System.in);
        userRepository.save(new User(name.nextLine(), password.nextLine()));
        chatClient.startClient(name.nextLine(), password.nextLine());
    }


    public void startClient(String username, String password) {
        try {

            Socket socket = new Socket("localhost", 5000);

            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            Scanner consoleScanner = new Scanner(System.in);

            Thread receiveThread = new Thread(() -> {
                while (true) {
                    if (scanner.hasNextLine()) {
                        String serverMessage = scanner.nextLine();
                        System.out.println("Servidor: " + serverMessage);
                    }
                }
            });
            receiveThread.start();

            Thread sendThread = new Thread(() -> {
                while (true) {
                    String clientMessage = consoleScanner.nextLine();
                    writer.println(username + ": " + clientMessage);
                    if (clientMessage.equals("")) {
                        System.out.println("Pressione Enter para enviar a mensagem.");
                    }
                }
            });
            sendThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
