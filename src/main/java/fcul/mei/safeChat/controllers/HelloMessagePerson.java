package fcul.mei.safeChat.controllers;

public class HelloMessagePerson {

    private String name;

    public HelloMessagePerson() {
    }

    public HelloMessagePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}