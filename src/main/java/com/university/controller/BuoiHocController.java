package com.university.controller;

import com.university.entity.BuoiHoc;
import com.university.service.BuoiHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/buoihocs")
public class BuoiHocController {

    @Autowired
    private BuoiHocService buoiHocService;

    @GetMapping
    public List<BuoiHoc> getAllBuoiHocs() {
        return buoiHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuoiHoc> getBuoiHocById(@PathVariable UUID id) {
        return buoiHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BuoiHoc> createBuoiHoc(@RequestBody BuoiHoc buoiHoc) {
        return ResponseEntity.ok(buoiHocService.save(buoiHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuoiHoc> updateBuoiHoc(@PathVariable UUID id, @RequestBody BuoiHoc buoiHocDetails) {
        return buoiHocService.findById(id)
                .map(bh -> {
                    bh.setThuTrongTuan(buoiHocDetails.getThuTrongTuan());
                    bh.setGioHoc(buoiHocDetails.getGioHoc());
                    bh.setLichHoc(buoiHocDetails.getLichHoc());
                    return ResponseEntity.ok(buoiHocService.save(bh));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuoiHoc(@PathVariable UUID id) {
        if (!buoiHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        buoiHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
