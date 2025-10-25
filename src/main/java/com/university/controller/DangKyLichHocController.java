package com.university.controller;

import com.university.entity.DangKyLichHoc;
import com.university.service.DangKyLichHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dangky")
@RequiredArgsConstructor
public class DangKyLichHocController {

    private final DangKyLichHocService service;

    // 🔹 Xem tất cả lịch học mà sinh viên đã đăng ký
    @GetMapping("/by-sinhvien/{sinhVienId}")
    public ResponseEntity<List<DangKyLichHoc>> getBySinhVien(@PathVariable UUID sinhVienId) {
        return ResponseEntity.ok(service.getBySinhVien(sinhVienId));
    }

    // 🔹 Đăng ký lịch học
    @PostMapping("/{sinhVienId}/{lichHocId}")
    public ResponseEntity<DangKyLichHoc> register(@PathVariable UUID sinhVienId, @PathVariable UUID lichHocId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(sinhVienId, lichHocId));
    }

    // 🔹 Hủy đăng ký
    @DeleteMapping("/{sinhVienId}/{lichHocId}")
    public ResponseEntity<Void> unregister(@PathVariable UUID sinhVienId, @PathVariable UUID lichHocId) {
        service.unregister(sinhVienId, lichHocId);
        return ResponseEntity.noContent().build();
    }
}
