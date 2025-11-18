package com.university.controller;

import com.university.dto.reponse.TruongResponseDTO;
import com.university.dto.request.TruongRequestDTO;
import com.university.service.TruongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/truongs")
@RequiredArgsConstructor
public class TruongController {

    private final TruongService truongService;

    @GetMapping
    public ResponseEntity<List<TruongResponseDTO>> getAll() {
        return ResponseEntity.ok(truongService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruongResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(truongService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TruongResponseDTO> create(@RequestBody TruongRequestDTO dto) {
        return ResponseEntity.ok(truongService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TruongResponseDTO> update(@PathVariable UUID id, @RequestBody TruongRequestDTO dto) {
        return ResponseEntity.ok(truongService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        truongService.delete(id);
        return ResponseEntity.noContent().build();
    }
}