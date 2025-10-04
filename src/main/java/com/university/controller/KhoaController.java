package com.university.controller;

import com.university.dto.reponse.KhoaResponse;
import com.university.dto.request.KhoaRequest;
import com.university.service.KhoaService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/khoas")
public class KhoaController {

    private final KhoaService khoaService;

    public KhoaController(KhoaService khoaService) {
        this.khoaService = khoaService;
    }

    @PostMapping
    public ResponseEntity<KhoaResponse> create(@RequestBody KhoaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(khoaService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<KhoaResponse>> getAll() {
        return ResponseEntity.ok(khoaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhoaResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(khoaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhoaResponse> update(@PathVariable UUID id, @RequestBody KhoaRequest request) {
        return ResponseEntity.ok(khoaService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        khoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<KhoaResponse>> filterByTruong(
            @RequestParam UUID truongId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(khoaService.getByTruong(truongId, page, size));
    }
}