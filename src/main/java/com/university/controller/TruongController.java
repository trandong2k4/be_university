package com.university.controller;

import com.university.entity.Truong;
import com.university.service.TruongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/truongs")
public class TruongController {

    @Autowired
    private TruongService truongService;

    @GetMapping
    public List<Truong> getAllTruongs() {
        return truongService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truong> getTruongById(@PathVariable UUID id) {
        return truongService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Truong> createTruong(@RequestBody Truong truong) {
        if (truongService.existsByMaTruong(truong.getMaTruong()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(truongService.save(truong));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Truong> updateTruong(@PathVariable UUID id, @RequestBody Truong truongDetails) {
        return truongService.findById(id)
                .map(truong -> {
                    truong.setMaTruong(truongDetails.getMaTruong());
                    truong.setTenTruong(truongDetails.getTenTruong());
                    truong.setDiaChi(truongDetails.getDiaChi());
                    truong.setSoDienThoai(truongDetails.getSoDienThoai());
                    truong.setEmail(truongDetails.getEmail());
                    truong.setWebsite(truongDetails.getWebsite());
                    truong.setMoTa(truongDetails.getMoTa());
                    truong.setLogoUrl(truongDetails.getLogoUrl());
                    truong.setNgayThanhLap(truongDetails.getNgayThanhLap());
                    truong.setNguoiDaiDien(truongDetails.getNguoiDaiDien());
                    return ResponseEntity.ok(truongService.save(truong));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruong(@PathVariable UUID id) {
        if (!truongService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        truongService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
