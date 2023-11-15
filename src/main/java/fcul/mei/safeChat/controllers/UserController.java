package fcul.mei.safeChat.controllers;

import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.UserDto;
import fcul.mei.safeChat.services.UserService;
import fcul.mei.safeChat.utils.ControllerHandler;
import fcul.mei.safeChat.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserDto userDto){
        ControllerHandler.handleException(() -> {
            return userService.addUser(userDto);
        }, HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<User> getUser(@PathVariable String username){
        return ControllerHandler.handleException(() -> {
            return userService.getUser(username);
        },  HttpStatusCode.valueOf(200));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userDto) throws Exception {
        try{
            User user = userService.getUserByUsernameAndPassword(userDto);
            return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
        }catch(Exception error) {
            if (error.equals(new HttpResponse.UserNotFound())) {
                throw error;
            }else{
                throw new Exception("Invalid user");
            }
        }
    }
}
