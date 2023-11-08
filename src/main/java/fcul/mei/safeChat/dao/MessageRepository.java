package fcul.mei.safeChat.dao;

import fcul.mei.safeChat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
