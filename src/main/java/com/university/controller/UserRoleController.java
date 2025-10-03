package com.university.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.service.UserRoleResponse;
import com.university.service.UserRoleService;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/{userId}/assign/{roleId}")
    public ResponseEntity<UserRoleResponse> assign(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return ResponseEntity.ok(userRoleService.assign(userId, roleId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserRoleResponse>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userRoleService.getByUser(userId));
    }
}