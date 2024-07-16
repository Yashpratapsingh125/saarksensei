package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.User;
import com.Sensei.UserApp.error.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> fetchUserList();

    public User fetchUserById(Long userId) throws UserNotFoundException;

    public void deleteUserById(Long userId);

    public User updateUser(Long userId, User user);

    public User fetchUserByName(String userName);
}
