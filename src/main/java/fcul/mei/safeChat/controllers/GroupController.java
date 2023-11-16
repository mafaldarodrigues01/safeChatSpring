package fcul.mei.safeChat.controllers;

import fcul.mei.safeChat.model.Group;
import fcul.mei.safeChat.model.dto.GroupDto;
import fcul.mei.safeChat.services.GroupService;
import fcul.mei.safeChat.utils.ControllerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public void addGroup(@RequestBody GroupDto groupDto){
        ControllerHandler.handleException(()->{
            return groupService.addGroup(groupDto);
        }, HttpStatus.CREATED);
    }

  /*  @GetMapping("{username}/user")
    public ResponseEntity<List<Group>> getAllGroupsOfUser(@PathVariable String username){
        return ControllerHandler.handleException(()->groupService.getAllGroupsOfUser(username), HttpStatus.OK);
    }
*/
}
