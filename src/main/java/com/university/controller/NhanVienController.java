package com.university.controller;

import com.university.dto.reponse.NhanVienResponseDTO;
import com.university.dto.request.NhanVienRequestDTO;
import com.university.service.NhanVienService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/staffs")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @PostMapping
    public ResponseEntity<NhanVienResponseDTO> create(@RequestBody @Valid NhanVienRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nhanVienService.create(dto));
    }

    @GetMapping("/giangviens")
    public ResponseEntity<List<NhanVienResponseDTO>> getAllGiangVien() {
        return ResponseEntity.ok(nhanVienService.getAllGiangVien());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(nhanVienService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<NhanVienResponseDTO>> getAll() {
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid NhanVienRequestDTO dto) {
        return ResponseEntity.ok(nhanVienService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        nhanVienService.delete(id);
        return ResponseEntity.noContent().build();
    }
}