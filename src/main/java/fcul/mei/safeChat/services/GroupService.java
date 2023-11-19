package fcul.mei.safeChat.services;

import fcul.mei.safeChat.dao.GroupRepository;
import fcul.mei.safeChat.dao.UserRepository;
import fcul.mei.safeChat.model.Group;
import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.GroupDto;
import fcul.mei.safeChat.model.dto.GroupDtoOutput;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableList;

@Service
@Transactional
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public List<GroupDtoOutput> getAllGroupsOfUser(String username){
        List<GroupDtoOutput> groups = new ArrayList<>();
        List<Group> db = groupRepository.getAllGroupsFromAnUser(username);
        for (int i = 0; i< db.size(); ++i){
            groups.add(new GroupDtoOutput(db.get(i).getGroupName(),db.get(i).getGid()));
        }
        return groups ;
    }

    public Group addGroup(GroupDto groupDto){
        List<User> users = new ArrayList<>();
        for (int i = 0; i<groupDto.users.size(); ++i){
            users.add(userRepository.getUserByUsername(groupDto.users.get(i)));
        }
        return groupRepository.save(new Group(groupDto.groupName,users));
    }

}
