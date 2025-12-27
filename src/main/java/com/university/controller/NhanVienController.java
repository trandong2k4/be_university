package com.university.controller;

import com.university.dto.request.NhanVienRequestDTO;
import com.university.dto.response.NhanVienResponseDTO;
import com.university.dto.response.NhanVienResponseDTO.NhanVienView;
import com.university.enums.ViTriEnum;
import com.university.service.NhanVienService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.repository.query.Param;
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

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(nhanVienService.getById(id));
    }

    @GetMapping("/by-userId")
    public ResponseEntity<NhanVienView> getByUserId(@Param("userId") UUID userId) {
        return ResponseEntity.ok(nhanVienService.getNhanVienByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<NhanVienResponseDTO>> getAll() {
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @GetMapping("/by-vitri")
    public ResponseEntity<List<NhanVienResponseDTO>> getAllNhanVienByViTri(@RequestParam ViTriEnum viTri) {
        return ResponseEntity.ok(nhanVienService.getAllNhanVien(viTri));
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