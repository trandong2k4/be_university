package com.university.controller;

import com.university.dto.reponse.UserResponse;
import com.university.dto.request.UserRequest;
import com.university.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Lấy tất cả người dùng
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Lấy người dùng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Tạo mới người dùng
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    // Cập nhật người dùng
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable UUID id, @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    // Xóa người dùng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Gán vai trò cho người dùng
    @PostMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<Void> assignRole(@PathVariable UUID userId, @PathVariable UUID roleId) {
        userService.assignRole(userId, roleId);
        return ResponseEntity.ok().build();
    }
}