package com.project.questapp.controller;

import com.project.questapp.model.User;
import com.project.questapp.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserServiceRequest user) {
        User savedUser = userService.saveUser(user.toServiceRequest());
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id){
        if(userService.findUserById(id).isPresent()){
            return new ResponseEntity<>("User found",HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserServiceRequest user,@PathVariable Long id){
        if(userService.updateUser(user.toServiceRequest(),id)!=null){
            return new ResponseEntity<>("User updated successfully",HttpStatus.OK);
        }
       return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        if(userService.deleteUserById(id)){
            return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
    }
}
