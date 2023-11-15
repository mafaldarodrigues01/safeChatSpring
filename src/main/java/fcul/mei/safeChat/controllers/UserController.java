package fcul.mei.safeChat.controllers;

import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.UserDto;
import fcul.mei.safeChat.services.UserService;
import fcul.mei.safeChat.utils.ControllerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserDto userInput){
        ControllerHandler.handleException(() -> {
            return userService.addUser(userInput);
        });
    }

    @GetMapping
    public User getUser(@PathVariable String username){
        ControllerHandler.handleException(() -> {
            return userService.getUser(username);
        });
    }


}
