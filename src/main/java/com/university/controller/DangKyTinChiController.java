package com.university.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.university.entity.DangKyTinChi;
import com.university.service.DangKyTinChiService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedule_registrations")
@RequiredArgsConstructor
public class DangKyTinChiController {

    private final DangKyTinChiService service;

    // 🔹 Xem tất cả lịch học mà sinh viên đã đăng ký
    @GetMapping("/by-sinhvien/{sinhVienId}")
    public ResponseEntity<List<DangKyTinChi>> getBySinhVien(@PathVariable UUID sinhVienId) {
        return ResponseEntity.ok(service.getBySinhVien(sinhVienId));
    }

    // 🔹 Đăng ký lịch học
    @PostMapping("/{sinhVienId}/{lophocphanId}")
    public ResponseEntity<DangKyTinChi> register(@PathVariable UUID sinhVienId, @PathVariable UUID lophocphanId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.DangKiTinChiSinhVien(sinhVienId, lophocphanId));
    }

    // 🔹 Hủy đăng ký
    @DeleteMapping("/{sinhVienId}/{lophocphanId}")
    public ResponseEntity<Void> unregister(@PathVariable UUID sinhVienId, @PathVariable UUID lophocphanId) {
        service.unregister(sinhVienId, lophocphanId);
        return ResponseEntity.noContent().build();
    }
}
