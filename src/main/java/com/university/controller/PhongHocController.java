package com.university.controller;

import com.university.dto.reponse.PhongHocResponseDTO;
import com.university.dto.request.PhongHocRequestDTO;
import com.university.service.PhongHocService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class PhongHocController {

    private final PhongHocService phongHocService;

    @PostMapping
    public ResponseEntity<PhongHocResponseDTO> create(@RequestBody @Valid PhongHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(phongHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<PhongHocResponseDTO>> getAll() {
        return ResponseEntity.ok(phongHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhongHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(phongHocService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PhongHocResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(phongHocService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhongHocResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid PhongHocRequestDTO dto) {
        return ResponseEntity.ok(phongHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        phongHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}