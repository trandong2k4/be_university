package com.university.controller;

import com.university.entity.Khoa;
import com.university.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/khoas")
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public List<Khoa> getAllKhoas() {
        return khoaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Khoa> getKhoaById(@PathVariable UUID id) {
        return khoaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Khoa> createKhoa(@RequestBody Khoa khoa) {
        if (khoaService.existsByMaKhoa(khoa.getMaKhoa()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(khoaService.save(khoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Khoa> updateKhoa(@PathVariable UUID id, @RequestBody Khoa khoaDetails) {
        return khoaService.findById(id)
                .map(khoa -> {
                    khoa.setMaKhoa(khoaDetails.getMaKhoa());
                    khoa.setTenKhoa(khoaDetails.getTenKhoa());
                    khoa.setTruong(khoaDetails.getTruong());
                    return ResponseEntity.ok(khoaService.save(khoa));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhoa(@PathVariable UUID id) {
        if (!khoaService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        khoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
