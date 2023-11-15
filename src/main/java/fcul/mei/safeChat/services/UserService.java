package fcul.mei.safeChat.services;

import fcul.mei.safeChat.dao.UserRepository;
import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.UserDto;
import fcul.mei.safeChat.utils.HttpResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(UserDto userDto){
        return userRepository.save(new User(userDto.username, userDto.password));
    }

    public User getUser(String username){
        return userRepository.getUserByUsername(username);
    }

    public User getUserByUsernameAndPassword(UserDto userDto) throws HttpResponse.UserNotFound {
        User user = userRepository.getUserByUsernameAndPassword(userDto.username, userDto.password);
        if (user == null) throw new HttpResponse.UserNotFound();
        return user;
    }
}
