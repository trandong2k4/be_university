package com.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.university.entity.User;
import com.university.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ by username
    public User findUser(String username) {
        return userRepository.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // READ all
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    public User updateUser(String username, User updatedUser) {
        User existingUser = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        // thêm các trường khác nếu cần
        return userRepository.save(existingUser);
    }

    // DELETE by username
    public User deleteUser(String username) {
        User user = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRepository.delete(user);
        return user;
    }

    // DELETE all
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}