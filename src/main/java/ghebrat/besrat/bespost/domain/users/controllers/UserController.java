package ghebrat.besrat.bespost.domain.users.controllers;

import ghebrat.besrat.bespost.domain.users.exceptions.UserNotFoundException;
import ghebrat.besrat.bespost.domain.users.models.User;
import ghebrat.besrat.bespost.domain.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
       return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user) throws UserNotFoundException {
        userService.createUser(user);
    }

    @GetMapping("/id/{userId}")
    public void getByID(@PathVariable ("userId") Long userId){
        userService.findById(userId);
    }

    @GetMapping("/id/{userEmail}")
    public Optional<User> getByEmail(@PathVariable("userEmail") String email){
        return userService.findByEmail(email);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }





/*
create user -
get user by id -
get user by email -
get all users -
update user
delete user
* */
}
