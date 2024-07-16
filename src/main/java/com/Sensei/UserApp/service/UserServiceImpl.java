package com.Sensei.UserApp.service;

import com.Sensei.UserApp.entity.User;
import com.Sensei.UserApp.error.UserNotFoundException;
import com.Sensei.UserApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()){
            throw new UserNotFoundException("User Not Available");
        }
        return user.get();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userDB = userRepository.findById(userId).get();
        if(Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())){
            userDB.setUserName(user.getUserName());
        }

        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            userDB.setEmail(user.getEmail());
        }

        if(Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())){
            userDB.setPhoneNumber(user.getPhoneNumber());
        }
        return userRepository.save(userDB);
    }

    @Override
    public User fetchUserByName(String userName) {
        return userRepository.findByUserNameIgnoreCase(userName);
    }
}