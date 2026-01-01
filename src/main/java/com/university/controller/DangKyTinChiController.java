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
@RequestMapping("/dang-ky-tin-chi")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Đảm bảo không bị lỗi CORS
public class DangKyTinChiController {

    private final DangKyTinChiService service;

    // Thay @Param bằng @PathVariable
    @GetMapping("/by-sinhvien/{sinhVienId}")
    public ResponseEntity<List<DangKyTinChi>> getBySinhVien(@PathVariable UUID sinhVienId) {
        return ResponseEntity.ok(service.getBySinhVien(sinhVienId));
    }

    @PostMapping("/{sinhVienId}/{lophocphanId}")
    public ResponseEntity<DangKyTinChi> register(
            @PathVariable UUID sinhVienId,
            @PathVariable UUID lophocphanId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.DangKiTinChiSinhVien(sinhVienId, lophocphanId));
    }

    @DeleteMapping("/{sinhVienId}/{lophocphanId}")
    public ResponseEntity<String> unregister(
            @PathVariable UUID sinhVienId,
            @PathVariable UUID lophocphanId) {

        String message = service.unregister(sinhVienId, lophocphanId);
        return ResponseEntity.ok(message);
    }

}