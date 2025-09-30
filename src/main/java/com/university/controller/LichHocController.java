package com.university.controller;

import com.university.entity.LichHoc;
import com.university.service.LichHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lichhocs")
public class LichHocController {

    @Autowired
    private LichHocService lichHocService;

    @GetMapping
    public List<LichHoc> getAllLichHocs() {
        return lichHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LichHoc> getLichHocById(@PathVariable UUID id) {
        return lichHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LichHoc> createLichHoc(@RequestBody LichHoc lichHoc) {
        return ResponseEntity.ok(lichHocService.save(lichHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LichHoc> updateLichHoc(@PathVariable UUID id, @RequestBody LichHoc lichHocDetails) {
        return lichHocService.findById(id)
                .map(lh -> {
                    lh.setNgayBatDau(lichHocDetails.getNgayBatDau());
                    lh.setNgayKetThuc(lichHocDetails.getNgayKetThuc());
                    lh.setPhongHoc(lichHocDetails.getPhongHoc());
                    lh.setKiHoc(lichHocDetails.getKiHoc());
                    lh.setMonHoc(lichHocDetails.getMonHoc());
                    return ResponseEntity.ok(lichHocService.save(lh));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLichHoc(@PathVariable UUID id) {
        if (!lichHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        lichHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
