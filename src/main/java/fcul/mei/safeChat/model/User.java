package fcul.mei.safeChat.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "User")
@Table(name = "userr")
public class User {

    @Id
    @Column(name = "username")
     String username;

    @Column(name = "password")
     String password;

    @ManyToMany(mappedBy="users")
     Set<Group> groups;

    @OneToMany(mappedBy = "user")
    Set<Message> messages;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){
        this.username = null;
        this.password = null;
    }

}
