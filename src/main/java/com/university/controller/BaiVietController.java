package com.university.controller;

import com.university.dto.reponse.BaiVietResponse;
import com.university.dto.request.BaiVietRequest;
import com.university.service.BaiVietService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/baiviets")
public class BaiVietController {

    private final BaiVietService baiVietService;

    public BaiVietController(BaiVietService baiVietService) {
        this.baiVietService = baiVietService;
    }

    @PostMapping
    public ResponseEntity<BaiVietResponse> create(@RequestBody BaiVietRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(baiVietService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaiVietResponse> update(@PathVariable UUID id, @RequestBody BaiVietRequest request) {
        return ResponseEntity.ok(baiVietService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaiVietResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(baiVietService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BaiVietResponse>> getAll() {
        return ResponseEntity.ok(baiVietService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        baiVietService.delete(id);
        return ResponseEntity.noContent().build();
    }
}