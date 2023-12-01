package fcul.mei.safeChat.controllers;

public class Message {
    private String from;
    private String text;

    public Message(String from, String text) {
        this.from = from;
        this.text = text;
    }

    String getFrom(){
        return this.from;
    }

    String getText(){
        return this.text;
    }


}
