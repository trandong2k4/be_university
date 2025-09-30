package com.university.controller;

import com.university.entity.Role;
import com.university.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable UUID id) {
        return roleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        if (roleService.existsByMaRole(role.getMaRole()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(roleService.save(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable UUID id, @RequestBody Role roleDetails) {
        return roleService.findById(id)
                .map(role -> {
                    role.setMaRole(roleDetails.getMaRole());
                    role.setDescription(roleDetails.getDescription());
                    return ResponseEntity.ok(roleService.save(role));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
        if (!roleService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
