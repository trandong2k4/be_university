package com.university.controller;

import com.university.dto.reponse.SinhVienResponse;
import com.university.dto.request.SinhVienRequest;
import com.university.service.SinhVienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sinhviens")
public class SinhVienController {

    private final SinhVienService service;

    public SinhVienController(SinhVienService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SinhVienResponse> create(@RequestBody SinhVienRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SinhVienResponse> update(@PathVariable UUID id, @RequestBody SinhVienRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SinhVienResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SinhVienResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SinhVienResponse>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }
}