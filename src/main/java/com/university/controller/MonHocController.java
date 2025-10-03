package com.university.controller;

import com.university.dto.reponse.MonHocResponse;
import com.university.dto.request.MonHocRequest;
import com.university.service.MonHocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/monhocs")
public class MonHocController {

    private final MonHocService monHocService;

    public MonHocController(MonHocService monHocService) {
        this.monHocService = monHocService;
    }

    @PostMapping
    public ResponseEntity<MonHocResponse> create(@RequestBody MonHocRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monHocService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MonHocResponse>> getAll() {
        return ResponseEntity.ok(monHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonHocResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(monHocService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonHocResponse> update(@PathVariable UUID id, @RequestBody MonHocRequest request) {
        return ResponseEntity.ok(monHocService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        monHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
