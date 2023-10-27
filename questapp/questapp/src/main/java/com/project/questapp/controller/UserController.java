package com.project.questapp.controller;

import com.project.questapp.entity.User;
import com.project.questapp.service.user.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    public User save(@RequestBody UserServiceRequest user){
      return userService.saveUser(user.toServiceRequest());
    }

}
