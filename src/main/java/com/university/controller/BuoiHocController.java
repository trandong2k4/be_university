package com.university.controller;

import com.university.dto.reponse.BuoiHocResponseDTO;
import com.university.dto.request.BuoiHocRequestDTO;
import com.university.service.BuoiHocService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/buoihocs")
@RequiredArgsConstructor
public class BuoiHocController {

    private final BuoiHocService buoiHocService;

    @PostMapping
    public ResponseEntity<BuoiHocResponseDTO> create(@RequestBody @Valid BuoiHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(buoiHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<BuoiHocResponseDTO>> getAll() {
        return ResponseEntity.ok(buoiHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuoiHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(buoiHocService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BuoiHocResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(buoiHocService.search(keyword));
    }

    @GetMapping("/ngay")
    public ResponseEntity<List<BuoiHocResponseDTO>> getByNgayHoc(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ngayHoc) {
        return ResponseEntity.ok(buoiHocService.getByNgayHoc(ngayHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuoiHocResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid BuoiHocRequestDTO dto) {
        return ResponseEntity.ok(buoiHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        buoiHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}