package com.university.controller;

import com.university.dto.reponse.ViTriResponseDTO;
import com.university.dto.request.ViTriRequestDTO;
import com.university.service.ViTriService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class ViTriController {

    private final ViTriService viTriService;

    @PostMapping
    public ResponseEntity<ViTriResponseDTO> create(@RequestBody @Valid ViTriRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(viTriService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViTriResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(viTriService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ViTriResponseDTO>> getAll() {
        return ResponseEntity.ok(viTriService.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ViTriResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(viTriService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViTriResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid ViTriRequestDTO dto) {
        return ResponseEntity.ok(viTriService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        viTriService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
