package com.university.controller;

import com.university.dto.reponse.PermissionResponseDTO;
import com.university.dto.request.PermissionRequestDTO;
import com.university.service.auth.PermissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<PermissionResponseDTO> create(@RequestBody @Valid PermissionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponseDTO>> getAll() {
        return ResponseEntity.ok(permissionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(permissionService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PermissionResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(permissionService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid PermissionRequestDTO dto) {
        return ResponseEntity.ok(permissionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        permissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}