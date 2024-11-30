package com.booklibrary.Controller;

import com.booklibrary.Service.UserService;
import com.booklibrary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public String User(@RequestBody User user){
        userService.saveUser(user);
        return("user Created");
    }
    @GetMapping("/getAllUsers")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/userById/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @PutMapping("/updateUser/{id}")
    public String updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(id ,user);
        return ("User updated");
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ("user deleted");
    }
}
