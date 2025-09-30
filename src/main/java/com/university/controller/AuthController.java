package com.university.controller;

import com.university.dto.LoginRequest;
import com.university.entity.User;
import com.university.service.UserService;
import com.university.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userService.findByUsername(request.getUsername())
                .map(user -> {
                    if (passwordEncoder.matches(request.getPassword(), request.getPassword())) {
                        String token = jwtUtil.generateToken(user.getUsername());
                        return ResponseEntity.ok(Map.of(
                                "status", "success",
                                "username", user.getUsername(),
                                "token", token));
                    } else {
                        return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password"));
                    }
                })
                .orElse(ResponseEntity.status(401).body(Map.of("message", "Invalid username or password")));
    }

    @PostMapping("/forgetpassword")
    public ResponseEntity<?> forgetPassword(@RequestBody User request) {
        // Tạm thời hardcode, sau này check DB hoặc gửi mail
        if ("admin".equals(request.getUsername())) {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Reset password link sent",
                    "username", request.getUsername()));
        }
        return ResponseEntity.status(404).body(Map.of(
                "status", "error",
                "message", "Username not found"));
    }
}
