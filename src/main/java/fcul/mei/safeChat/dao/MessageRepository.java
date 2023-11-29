package fcul.mei.safeChat.dao;

import fcul.mei.safeChat.model.Message;
import fcul.mei.safeChat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT * FROM MESSAGE m WHERE m.gid = :gid", nativeQuery = true)
    List<Message> getAllMessagesOfGroup(@Param("gid") Integer gid);

}
