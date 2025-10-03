package com.university.controller;

import com.university.dto.reponse.NhanVienResponse;
import com.university.dto.request.NhanVienRequest;
import com.university.service.NhanVienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nhanviens")
public class NhanVienController {

    private final NhanVienService nhanVienService;

    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @PostMapping
    public ResponseEntity<NhanVienResponse> create(@RequestBody NhanVienRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nhanVienService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<NhanVienResponse>> getAll() {
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(nhanVienService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienResponse> update(@PathVariable UUID id, @RequestBody NhanVienRequest request) {
        return ResponseEntity.ok(nhanVienService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        nhanVienService.delete(id);
        return ResponseEntity.noContent().build();
    }
}