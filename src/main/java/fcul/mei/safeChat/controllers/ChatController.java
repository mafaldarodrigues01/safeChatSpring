package fcul.mei.safeChat.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessagePerson sendMessage(ChatMessagePerson chatMessage) {
        return chatMessage;
    }
}
