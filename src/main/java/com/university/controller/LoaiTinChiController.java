package com.university.controller;

import com.university.entity.LoaiTinChi;
import com.university.service.LoaiTinChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loaitinchi")
public class LoaiTinChiController {

    @Autowired
    private LoaiTinChiService loaiTinChiService;

    @GetMapping
    public List<LoaiTinChi> getAllLoaiTinChi() {
        return loaiTinChiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiTinChi> getLoaiTinChiById(@PathVariable UUID id) {
        return loaiTinChiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoaiTinChi> createLoaiTinChi(@RequestBody LoaiTinChi loaiTinChi) {
        if (loaiTinChiService.existsByMaLoaiTinChi(loaiTinChi.getMaLoaiTinChi()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(loaiTinChiService.save(loaiTinChi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiTinChi> updateLoaiTinChi(@PathVariable UUID id,
            @RequestBody LoaiTinChi loaiTinChiDetails) {
        return loaiTinChiService.findById(id)
                .map(ltc -> {
                    ltc.setMaLoaiTinChi(loaiTinChiDetails.getMaLoaiTinChi());
                    ltc.setTenLoaiTinChi(loaiTinChiDetails.getTenLoaiTinChi());
                    return ResponseEntity.ok(loaiTinChiService.save(ltc));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoaiTinChi(@PathVariable UUID id) {
        if (!loaiTinChiService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        loaiTinChiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
