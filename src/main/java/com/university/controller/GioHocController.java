package com.university.controller;

import com.university.entity.GioHoc;
import com.university.service.GioHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/giohocs")
public class GioHocController {

    @Autowired
    private GioHocService gioHocService;

    @GetMapping
    public List<GioHoc> getAllGioHocs() {
        return gioHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GioHoc> getGioHocById(@PathVariable UUID id) {
        return gioHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GioHoc> createGioHoc(@RequestBody GioHoc gioHoc) {
        if (gioHocService.existsByMaGioHoc(gioHoc.getMaGioHoc()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(gioHocService.save(gioHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GioHoc> updateGioHoc(@PathVariable UUID id, @RequestBody GioHoc gioHocDetails) {
        return gioHocService.findById(id)
                .map(gh -> {
                    gh.setMaGioHoc(gioHocDetails.getMaGioHoc());
                    gh.setTenGioHoc(gioHocDetails.getTenGioHoc());
                    gh.setThoiGianBatDau(gioHocDetails.getThoiGianBatDau());
                    gh.setThoiGianKetThuc(gioHocDetails.getThoiGianKetThuc());
                    return ResponseEntity.ok(gioHocService.save(gh));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGioHoc(@PathVariable UUID id) {
        if (!gioHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        gioHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
