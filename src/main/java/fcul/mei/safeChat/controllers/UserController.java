package fcul.mei.safeChat.controllers;

import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.UserDto;
import fcul.mei.safeChat.model.dto.UserDtoOutput;
import fcul.mei.safeChat.services.UserService;
import fcul.mei.safeChat.utils.ControllerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserDto userDto){
        ControllerHandler.handleException(() -> userService.addUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDtoOutput> login(@RequestBody UserDto userDto) throws Exception {
        return ControllerHandler.handleException(() -> userService.getUserByUsernameAndPassword(userDto), HttpStatus.OK);
    }
}
