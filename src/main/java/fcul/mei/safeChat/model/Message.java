package fcul.mei.safeChat.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity(name = "Message")
@Table(name = "message")
public class Message {

    @Id
    @Column(name = "mid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;

    @Column(name = "text")
    @NonNull
    private String message;

    @ManyToOne
    @JoinColumn(name = "uid")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "gid")
    @NonNull
    private Group group;

    public Message(String message, User user, Group group){
        this.message = message;
        this.user = user;
        this.group = group;
    }

    public Message(){
        this.message = "";
        this.user = new User();
        this.group = new Group();
    }

}
