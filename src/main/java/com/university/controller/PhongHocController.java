package com.university.controller;

import com.university.dto.reponse.PhongHocResponse;
import com.university.dto.request.PhongHocRequest;
import com.university.service.PhongHocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/phonghocs")
public class PhongHocController {

    private final PhongHocService phongHocService;

    public PhongHocController(PhongHocService phongHocService) {
        this.phongHocService = phongHocService;
    }

    @PostMapping
    public ResponseEntity<PhongHocResponse> create(@RequestBody PhongHocRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(phongHocService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PhongHocResponse>> getAll() {
        return ResponseEntity.ok(phongHocService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhongHocResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(phongHocService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhongHocResponse> update(@PathVariable UUID id, @RequestBody PhongHocRequest request) {
        return ResponseEntity.ok(phongHocService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        phongHocService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PhongHocResponse>> search(@RequestParam("toaNha") String toaNha) {
        return ResponseEntity.ok(phongHocService.searchByToaNha(toaNha));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PhongHocResponse>> filterByTangAndSucChua(
            @RequestParam Integer tang,
            @RequestParam Integer sucChua) {
        return ResponseEntity.ok(phongHocService.filterByTangAndSucChua(tang, sucChua));
    }
}