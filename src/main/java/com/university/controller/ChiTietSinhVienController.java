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

import com.university.dto.reponse.ChiTietSinhVienResponse;
import com.university.dto.request.ChiTietSinhVienRequest;
import com.university.service.ChiTietSinhVienService;

@RestController
@RequestMapping("/api/chitiet-sinhvien")
public class ChiTietSinhVienController {

    private final ChiTietSinhVienService service;

    public ChiTietSinhVienController(ChiTietSinhVienService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ChiTietSinhVienResponse> create(@RequestBody ChiTietSinhVienRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiTietSinhVienResponse> update(@PathVariable UUID id,
            @RequestBody ChiTietSinhVienRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiTietSinhVienResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChiTietSinhVienResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ChiTietSinhVienResponse>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }
}