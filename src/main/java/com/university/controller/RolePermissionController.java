package com.university.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.dto.reponse.RolePermissionResponse;
import com.university.service.RolePermissionService;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping("/{roleId}/assign/{permissionId}")
    public ResponseEntity<RolePermissionResponse> assign(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        return ResponseEntity.ok(rolePermissionService.assign(roleId, permissionId));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<List<RolePermissionResponse>> getByRole(@PathVariable UUID roleId) {
        return ResponseEntity.ok(rolePermissionService.getByRole(roleId));
    }
}
