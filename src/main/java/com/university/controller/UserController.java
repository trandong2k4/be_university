package com.university.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.university.entity.User;
import com.university.service.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:8080") // đổi thành FE của bạn
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "Controller OK";
    }

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET all users
    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    // GET user by username
    @GetMapping("/get/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.findUser(username);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // CREATE user
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        if (savedUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    // UPDATE user
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user) {
        User updatedUser = userService.updateUser(username, user);
        return (updatedUser != null)
                ? ResponseEntity.ok(updatedUser)
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Cannot find User with username=" + username);
    }

    // DELETE user
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        User deletedUser = userService.deleteUser(username);
        return (deletedUser != null)
                ? ResponseEntity.ok("User deleted successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Cannot find User with username=" + username);
    }

    // DELETE all users
    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok("All users deleted successfully.");
    }
}
