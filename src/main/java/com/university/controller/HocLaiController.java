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

import com.university.dto.reponse.HocLaiResponseDTO;
import com.university.dto.request.HocLaiRequestDTO;
import com.university.service.HocLaiService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/hoclais")
@RequiredArgsConstructor
public class HocLaiController {

    private final HocLaiService hocLaiService;

    @PostMapping
    public ResponseEntity<HocLaiResponseDTO> create(@RequestBody @Valid HocLaiRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hocLaiService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<HocLaiResponseDTO>> getAll() {
        return ResponseEntity.ok(hocLaiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocLaiResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(hocLaiService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HocLaiResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(hocLaiService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocLaiResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid HocLaiRequestDTO dto) {
        return ResponseEntity.ok(hocLaiService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        hocLaiService.delete(id);
        return ResponseEntity.noContent().build();
    }
}