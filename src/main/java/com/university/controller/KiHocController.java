package com.university.controller;

import com.university.dto.request.KiHocRequestDTO;
import com.university.dto.response.KiHocResponseDTO;
import com.university.service.KiHocService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/semesters")
@RequiredArgsConstructor
public class KiHocController {

    private final KiHocService kiHocService;

    @PostMapping
    public ResponseEntity<KiHocResponseDTO> create(@RequestBody @Valid KiHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kiHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<KiHocResponseDTO>> getAll() {
        return ResponseEntity.ok(kiHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KiHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(kiHocService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<KiHocResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(kiHocService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KiHocResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid KiHocRequestDTO dto) {
        return ResponseEntity.ok(kiHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        kiHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
