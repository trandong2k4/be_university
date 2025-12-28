package com.university.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.repository.query.Param;
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
    public ResponseEntity<List<DangKyTinChi>> getBySinhVien(@Param("sinhVienId") UUID sinhVienId) {
        return ResponseEntity.ok(service.getBySinhVien(sinhVienId));
    }

    // 🔹 Đăng ký lịch học
    @PostMapping("/{sinhVienId}/{lophocphanId}")
    public ResponseEntity<DangKyTinChi> register(@Param("sinhVienId") UUID sinhVienId,
            @Param("lophocphanId") UUID lophocphanId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.DangKiTinChiSinhVien(sinhVienId, lophocphanId));
    }

    // 🔹 Hủy đăng ký
    @DeleteMapping("/{sinhVienId}/{lophocphanId}")
    public ResponseEntity<Void> unregister(@Param("sinhVienId") UUID sinhVienId,
            @Param("lophocphanId") UUID lophocphanId) {
        service.unregister(sinhVienId, lophocphanId);
        return ResponseEntity.noContent().build();
    }
}
