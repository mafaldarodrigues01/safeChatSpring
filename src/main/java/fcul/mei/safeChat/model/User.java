package fcul.mei.safeChat.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "User")
@Table(name = "userr")
public class User {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer uid;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @ManyToMany(mappedBy="users")
    Set<Group> groups;

    @OneToMany(mappedBy = "user")
    Set<Message> messages;

    public Integer getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){
        this.username = null;
        this.password = null;
    }

}
