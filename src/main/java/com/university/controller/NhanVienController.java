package com.university.controller;

import com.university.entity.NhanVien;
import com.university.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nhanviens")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVien> getAllNhanViens() {
        return nhanVienService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable UUID id) {
        return nhanVienService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVien nhanVien) {
        if (nhanVienService.existsByEmail(nhanVien.getEmail()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(nhanVienService.save(nhanVien));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable UUID id, @RequestBody NhanVien nhanVienDetails) {
        return nhanVienService.findById(id)
                .map(nhanVien -> {
                    nhanVien.setHoTen(nhanVienDetails.getHoTen());
                    nhanVien.setEmail(nhanVienDetails.getEmail());
                    nhanVien.setSoDienThoai(nhanVienDetails.getSoDienThoai());
                    nhanVien.setNgayVaoLam(nhanVienDetails.getNgayVaoLam());
                    nhanVien.setNgayNghiViec(nhanVienDetails.getNgayNghiViec());
                    nhanVien.setViTri(nhanVienDetails.getViTri());
                    nhanVien.setUser(nhanVienDetails.getUser());
                    return ResponseEntity.ok(nhanVienService.save(nhanVien));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable UUID id) {
        if (!nhanVienService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        nhanVienService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
