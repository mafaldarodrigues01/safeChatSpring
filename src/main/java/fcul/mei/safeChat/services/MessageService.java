package fcul.mei.safeChat.services;

import fcul.mei.safeChat.dao.GroupRepository;
import fcul.mei.safeChat.dao.MessageRepository;
import fcul.mei.safeChat.dao.UserRepository;
import fcul.mei.safeChat.model.Group;
import fcul.mei.safeChat.model.Message;
import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.MessageDto;
import fcul.mei.safeChat.model.dto.MessageDtoOutput;
import fcul.mei.safeChat.utils.ControllerHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;

    public void addMessage(MessageDto message){
        User u = userRepository.getReferenceById(message.gid);
        Group g = groupRepository.getReferenceById(message.gid);
        Message m = new Message(message.message, u, g);
        ControllerHandler.handleException(() -> messageRepository.save(m), HttpStatus.CREATED);
    }

    public List<MessageDtoOutput> getAllMessagesOfGroup(Integer gid){
        messageRepository.getAllMessagesOfGroup(gid);
        return null;
    }

}
