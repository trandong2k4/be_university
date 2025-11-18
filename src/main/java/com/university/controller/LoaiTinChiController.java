package com.university.controller;

import com.university.dto.reponse.LoaiTinChiResponseDTO;
import com.university.dto.request.LoaiTinChiRequestDTO;
import com.university.service.LoaiTinChiService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loaitinchis")
@RequiredArgsConstructor
public class LoaiTinChiController {

    private final LoaiTinChiService loaiTinChiService;

    @PostMapping
    public ResponseEntity<LoaiTinChiResponseDTO> create(@RequestBody @Valid LoaiTinChiRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loaiTinChiService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<LoaiTinChiResponseDTO>> getAll() {
        return ResponseEntity.ok(loaiTinChiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiTinChiResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(loaiTinChiService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<LoaiTinChiResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(loaiTinChiService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiTinChiResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid LoaiTinChiRequestDTO dto) {
        return ResponseEntity.ok(loaiTinChiService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        loaiTinChiService.delete(id);
        return ResponseEntity.noContent().build();
    }
}