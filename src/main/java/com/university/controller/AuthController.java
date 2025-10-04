package com.university.controller;

import com.university.dto.request.LoginRequest;
import com.university.dto.reponse.LoginResponse;
import com.university.dto.reponse.RegisterReponse;
import com.university.dto.request.RegisterRequest;
import com.university.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.authenticate(request.getUsername(), request.getPassword());
        System.out.println("Đăng nhập thành công: " + response.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterReponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }
}
