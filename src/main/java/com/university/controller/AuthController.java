package com.university.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.entity.User;
import com.university.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {
        User user = userService.findUser(request.getUsername());
        // tạm thời hardcode (sau có thể check DB + JWT)
        if (user.getUsername().equals(request.getUsername()) && user.getPassword().equals(request.getPassword())) {
            // Tra ve role-premission
            String role_premission = "admin"; // = RolePremissionService.getrole?
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Login successful",
                    "username", request.getUsername(),
                    "admin/student/lecture/acouting", role_premission));
        }
        return ResponseEntity.status(401).body(Map.of(
                "status", "error",
                "message", "Invalid username or password"));
    }

    @PostMapping("/forgetpassword")
    public ResponseEntity<?> ForgetPassWord(@RequestBody User request) {
        // tạm thời hardcode (sau có thể check DB + JWT)
        if ("admin".equals(request.getUsername()) && "123456".equals(request.getPassword())) {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Login successful",
                    "username", request.getUsername()));
        }
        return ResponseEntity.status(401).body(Map.of(
                "status", "error",
                "message", "Invalid username or password"));
    }
}
