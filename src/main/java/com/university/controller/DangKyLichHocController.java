package com.university.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.dto.reponse.LichHocResponse;
import com.university.dto.request.DangKyLichHocRequest;
import com.university.service.DangKyLichHocService;

@RestController
@RequestMapping("/api/dangky-lichhoc")
public class DangKyLichHocController {

    private final DangKyLichHocService service;

    public DangKyLichHocController(DangKyLichHocService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> dangKy(@RequestBody DangKyLichHocRequest request) {
        service.dangKy(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/sinhvien/{id}")
    public ResponseEntity<List<LichHocResponse>> getLichHoc(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getLichHocBySinhVien(id));
    }
}
