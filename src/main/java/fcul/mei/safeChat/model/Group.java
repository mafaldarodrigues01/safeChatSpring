package fcul.mei.safeChat.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Iterator;
import java.util.Set;


@Entity(name = "Group")
@Table(name = "groupp")

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private int gid;

    @Column(name = "group_name")
    String groupName;

    @NonNull
    @ManyToMany(mappedBy = "")
    @JoinTable(name="group_user",
            joinColumns=@JoinColumn(name="username"),
            inverseJoinColumns=@JoinColumn(name="gid"))
    Set<User> users;

    @OneToMany(mappedBy = "group")
    Set<Message> messages;

    //creates a new window chat with no initial messages
    public Group(Set<User> users, String groupName){
        this.users = users;
        if(groupName != null)
            this.groupName = groupName;
        else
            this.groupName = groupNameGenerator(users);
    }

    public Group(){
        this.users = Set.of();
        this.groupName = null;
    }

    private static String groupNameGenerator(@org.jetbrains.annotations.NotNull Set<User> users){
        Iterator<User> iterator = users.iterator();
        StringBuilder groupName = new StringBuilder(iterator.next().username);
        if(users.size() == 1){
            return groupName.toString();
        }
        while (iterator.hasNext()){
            groupName.append(", ").append(iterator.next().username);
        }
        return groupName.toString();
    }
}
