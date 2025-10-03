package com.university.controller;

import com.university.dto.reponse.UserResponse;
import com.university.dto.request.UserRequest;
import com.university.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @PostMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<Void> assignRole(@PathVariable UUID userId, @PathVariable UUID roleId) {
        userService.assignRole(userId, roleId);
        return ResponseEntity.ok().build();
    }
}