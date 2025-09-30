package com.university.controller;

import com.university.entity.SinhVien;
import com.university.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sinhviens")
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping
    public List<SinhVien> getAllSinhViens() {
        return sinhVienService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SinhVien> getSinhVienById(@PathVariable UUID id) {
        return sinhVienService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SinhVien> createSinhVien(@RequestBody SinhVien sinhVien) {
        if (sinhVienService.existsByMaSinhVien(sinhVien.getMaSinhVien()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(sinhVienService.save(sinhVien));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SinhVien> updateSinhVien(@PathVariable UUID id, @RequestBody SinhVien sinhVienDetails) {
        return sinhVienService.findById(id)
                .map(sinhVien -> {
                    sinhVien.setMaSinhVien(sinhVienDetails.getMaSinhVien());
                    sinhVien.setHoTen(sinhVienDetails.getHoTen());
                    sinhVien.setEmail(sinhVienDetails.getEmail());
                    sinhVien.setSoDienThoai(sinhVienDetails.getSoDienThoai());
                    sinhVien.setNgayNhapHoc(sinhVienDetails.getNgayNhapHoc());
                    sinhVien.setNgayTotNghiep(sinhVienDetails.getNgayTotNghiep());
                    sinhVien.setNganhHoc(sinhVienDetails.getNganhHoc());
                    sinhVien.setUser(sinhVienDetails.getUser());
                    return ResponseEntity.ok(sinhVienService.save(sinhVien));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSinhVien(@PathVariable UUID id) {
        if (!sinhVienService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        sinhVienService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
