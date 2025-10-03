package com.university.controller;

import com.university.dto.reponse.NganhResponse;
import com.university.dto.request.NganhRequest;
import com.university.service.NganhService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nganhs")
public class NganhController {

    private final NganhService nganhService;

    public NganhController(NganhService nganhService) {
        this.nganhService = nganhService;
    }

    @PostMapping
    public ResponseEntity<NganhResponse> create(@RequestBody NganhRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nganhService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<NganhResponse>> getAll() {
        return ResponseEntity.ok(nganhService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NganhResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(nganhService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NganhResponse> update(@PathVariable UUID id, @RequestBody NganhRequest request) {
        return ResponseEntity.ok(nganhService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        nganhService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<NganhResponse>> filterByKhoa(
            @RequestParam UUID khoaId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(nganhService.getByKhoa(khoaId, page, size));
    }
}