package fcul.mei.safeChat.controllers;

import fcul.mei.safeChat.model.User;
import fcul.mei.safeChat.model.dto.UserDto;
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
        ControllerHandler.handleException(() -> {
            return userService.addUser(userDto);
        }, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
       /* return ControllerHandler.handleException(() -> {
            return userService.getUser(username);
        },  HttpStatus.OK);*/
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userDto) throws Exception {
        return ControllerHandler.handleException(() -> {
            return userService.getUserByUsernameAndPassword(userDto);
        }, HttpStatus.OK);
    }
      /*  try{
            User user = userService.getUserByUsernameAndPassword(userDto);
            return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
        }catch(Exception error) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User hasn't been found", error);
            }
        }*/
}
