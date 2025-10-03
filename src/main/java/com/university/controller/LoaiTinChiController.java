package com.university.controller;

import com.university.dto.reponse.LoaiTinChiResponse;
import com.university.dto.request.LoaiTinChiRequest;
import com.university.service.LoaiTinChiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loaitinchi")
public class LoaiTinChiController {

    private final LoaiTinChiService loaiTinChiService;

    public LoaiTinChiController(LoaiTinChiService loaiTinChiService) {
        this.loaiTinChiService = loaiTinChiService;
    }

    @PostMapping
    public ResponseEntity<LoaiTinChiResponse> create(@RequestBody LoaiTinChiRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loaiTinChiService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<LoaiTinChiResponse>> getAll() {
        return ResponseEntity.ok(loaiTinChiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiTinChiResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(loaiTinChiService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiTinChiResponse> update(@PathVariable UUID id, @RequestBody LoaiTinChiRequest request) {
        return ResponseEntity.ok(loaiTinChiService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        loaiTinChiService.delete(id);
        return ResponseEntity.noContent().build();
    }
}