package com.university.controller;

import com.university.dto.reponse.MonHocResponseDTO;
import com.university.dto.request.MonHocRequestDTO;
import com.university.service.MonHocService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/monhocs")
@RequiredArgsConstructor
public class MonHocController {

    private final MonHocService monHocService;

    @PostMapping
    public ResponseEntity<MonHocResponseDTO> create(@RequestBody @Valid MonHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<MonHocResponseDTO>> getAll() {
        return ResponseEntity.ok(monHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(monHocService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MonHocResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(monHocService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonHocResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid MonHocRequestDTO dto) {
        return ResponseEntity.ok(monHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        monHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}