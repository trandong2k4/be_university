package com.university.controller;

import com.university.dto.reponse.BaiVietResponseDTO;
import com.university.dto.request.BaiVietRequestDTO;
import com.university.service.BaiVietService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/baiviets")
@RequiredArgsConstructor
public class BaiVietController {

    private final BaiVietService baiVietService;

    @PostMapping
    public ResponseEntity<BaiVietResponseDTO> create(@RequestBody @Valid BaiVietRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(baiVietService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<BaiVietResponseDTO>> getAll() {
        return ResponseEntity.ok(baiVietService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaiVietResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(baiVietService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BaiVietResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(baiVietService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaiVietResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid BaiVietRequestDTO dto) {
        return ResponseEntity.ok(baiVietService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        baiVietService.delete(id);
        return ResponseEntity.noContent().build();
    }
}