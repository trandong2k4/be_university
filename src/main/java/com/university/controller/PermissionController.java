package com.university.controller;

import com.university.entity.Permission;
import com.university.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public List<Permission> getAllPermissions() {
        return permissionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable UUID id) {
        return permissionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        if (permissionService.existsByMaPermission(permission.getMaPermission()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(permissionService.save(permission));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable UUID id,
            @RequestBody Permission permissionDetails) {
        return permissionService.findById(id)
                .map(permission -> {
                    permission.setMaPermission(permissionDetails.getMaPermission());
                    permission.setDescription(permissionDetails.getDescription());
                    return ResponseEntity.ok(permissionService.save(permission));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable UUID id) {
        if (!permissionService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        permissionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
