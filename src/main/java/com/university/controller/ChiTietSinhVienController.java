package com.university.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.dto.reponse.ChiTietSinhVienResponseDTO;
import com.university.dto.request.ChiTietSinhVienRequestDTO;
import com.university.service.ChiTietSinhVienService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student_details")
@RequiredArgsConstructor
public class ChiTietSinhVienController {

    private final ChiTietSinhVienService chiTietSinhVienService;

    @PostMapping
    public ResponseEntity<ChiTietSinhVienResponseDTO> create(@RequestBody @Valid ChiTietSinhVienRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chiTietSinhVienService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ChiTietSinhVienResponseDTO>> getAll() {
        return ResponseEntity.ok(chiTietSinhVienService.getAll());
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<ChiTietSinhVienResponseDTO> getByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(chiTietSinhVienService.findByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiTietSinhVienResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(chiTietSinhVienService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ChiTietSinhVienResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(chiTietSinhVienService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiTietSinhVienResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid ChiTietSinhVienRequestDTO dto) {
        return ResponseEntity.ok(chiTietSinhVienService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        chiTietSinhVienService.delete(id);
        return ResponseEntity.noContent().build();
    }
}