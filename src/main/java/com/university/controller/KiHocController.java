package com.university.controller;

import com.university.dto.request.KiHocRequest;
import com.university.dto.request.KiHocResponse;
import com.university.service.KiHocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kihocs")
public class KiHocController {

    private final KiHocService kiHocService;

    public KiHocController(KiHocService kiHocService) {
        this.kiHocService = kiHocService;
    }

    @PostMapping
    public ResponseEntity<KiHocResponse> create(@RequestBody KiHocRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kiHocService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<KiHocResponse>> getAll() {
        return ResponseEntity.ok(kiHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KiHocResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(kiHocService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KiHocResponse> update(@PathVariable UUID id, @RequestBody KiHocRequest request) {
        return ResponseEntity.ok(kiHocService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        kiHocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
