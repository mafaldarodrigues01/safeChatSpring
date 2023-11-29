package fcul.mei.safeChat.model.dto;

public class MessageDtoOutput {
    public String message;
    public String username;

    public MessageDtoOutput(String message, String username){
        this.message = message;
        this.username = username;
    }
}
