package fcul.mei.safeChat.services;

import fcul.mei.safeChat.dao.GroupRepository;
import fcul.mei.safeChat.dao.UserRepository;
import fcul.mei.safeChat.model.Group;
import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.GroupDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

  /*  public List<Group> getAllGroupsOfUser(String username){
        return groupRepository.getAllGroupsFromAnUser(username);
    }
*/
    public Group addGroup(GroupDto groupDto){
        return groupRepository.save(new Group(groupDto.groupName,groupDto.users));
    }

}
