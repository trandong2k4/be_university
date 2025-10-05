package com.university.controller;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.service.LichHocService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lichhocs")
@RequiredArgsConstructor
public class LichHocController {

    private final LichHocService lichHocService;

    @PostMapping
    public ResponseEntity<LichHocResponseDTO> create(@RequestBody @Valid LichHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lichHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<LichHocResponseDTO>> getAll() {
        return ResponseEntity.ok(lichHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(lichHocService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<LichHocResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(lichHocService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LichHocResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid LichHocRequestDTO dto) {
        return ResponseEntity.ok(lichHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        lichHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}