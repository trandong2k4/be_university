package com.university.controller;

import com.university.entity.KiHoc;
import com.university.service.KiHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kihocs")
public class KiHocController {

    @Autowired
    private KiHocService kiHocService;

    @GetMapping
    public List<KiHoc> getAllKiHocs() {
        return kiHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KiHoc> getKiHocById(@PathVariable UUID id) {
        return kiHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KiHoc> createKiHoc(@RequestBody KiHoc kiHoc) {
        if (kiHocService.existsByMaKiHoc(kiHoc.getMaKiHoc()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(kiHocService.save(kiHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KiHoc> updateKiHoc(@PathVariable UUID id, @RequestBody KiHoc kiHocDetails) {
        return kiHocService.findById(id)
                .map(kh -> {
                    kh.setMaKiHoc(kiHocDetails.getMaKiHoc());
                    kh.setTenKiHoc(kiHocDetails.getTenKiHoc());
                    kh.setNgayBatDau(kiHocDetails.getNgayBatDau());
                    kh.setNgayKetThuc(kiHocDetails.getNgayKetThuc());
                    return ResponseEntity.ok(kiHocService.save(kh));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKiHoc(@PathVariable UUID id) {
        if (!kiHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        kiHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
