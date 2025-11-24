package com.university.controller;

import com.university.dto.reponse.GioHocResponseDTO;
import com.university.dto.request.GioHocRequestDTO;
import com.university.service.GioHocService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/class_times")
@RequiredArgsConstructor
public class GioHocController {

    private final GioHocService gioHocService;

    @PostMapping
    public ResponseEntity<GioHocResponseDTO> create(@RequestBody @Valid GioHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gioHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<GioHocResponseDTO>> getAll() {
        return ResponseEntity.ok(gioHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GioHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(gioHocService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GioHocResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(gioHocService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GioHocResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid GioHocRequestDTO dto) {
        return ResponseEntity.ok(gioHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        gioHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
