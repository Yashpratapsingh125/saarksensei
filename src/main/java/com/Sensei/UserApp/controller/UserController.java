package com.Sensei.UserApp.controller;

import com.Sensei.UserApp.entity.User;
import com.Sensei.UserApp.error.UserNotFoundException;
import com.Sensei.UserApp.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User user){
        LOGGER.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList(){
        LOGGER.info("Inside fetchUserList of UserController");
        return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") Long userId) throws UserNotFoundException {
        return userService.fetchUserById(userId);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return "User deleted Successfully";
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    @GetMapping("/users/name/{name}")
    public User fetchUserByName(@PathVariable("name") String userName){
        return userService.fetchUserByName(userName);
    }

}
