package com.university.controller;

import com.university.dto.request.LichHocRequestDTO;
import com.university.dto.response.LichHocResponseDTO;
import com.university.dto.response.LichHocSinhVienResponseDTO;
import com.university.repository.LichHocRepository;
import com.university.service.LichHocService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class LichHocController {

    private final LichHocService lichHocService;
    private final LichHocRepository lichHocRepository;

    @PostMapping
    public ResponseEntity<LichHocResponseDTO> create(@RequestBody @Valid LichHocRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lichHocService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<LichHocResponseDTO>> getAll() {
        return ResponseEntity.ok(lichHocService.getAll());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<LichHocSinhVienResponseDTO>> getScheduleByStudent(
            @PathVariable UUID studentId) {
        return ResponseEntity.ok(
                lichHocRepository.findScheduleBySinhVien(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichHocResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(lichHocService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LichHocResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid LichHocRequestDTO dto) {
        return ResponseEntity.ok(lichHocService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        lichHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}