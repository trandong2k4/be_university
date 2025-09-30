package com.university.controller;

import com.university.entity.PhongHoc;
import com.university.service.PhongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/phonghocs")
public class PhongHocController {

    @Autowired
    private PhongHocService phongHocService;

    @GetMapping
    public List<PhongHoc> getAllPhongHocs() {
        return phongHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhongHoc> getPhongHocById(@PathVariable UUID id) {
        return phongHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PhongHoc> createPhongHoc(@RequestBody PhongHoc phongHoc) {
        if (phongHocService.existsByMaPhongHoc(phongHoc.getMaPhongHoc()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(phongHocService.save(phongHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhongHoc> updatePhongHoc(@PathVariable UUID id, @RequestBody PhongHoc phongHocDetails) {
        return phongHocService.findById(id)
                .map(ph -> {
                    ph.setMaPhongHoc(phongHocDetails.getMaPhongHoc());
                    ph.setTenPhong(phongHocDetails.getTenPhong());
                    ph.setToaNha(phongHocDetails.getToaNha());
                    ph.setTang(phongHocDetails.getTang());
                    ph.setSucChua(phongHocDetails.getSucChua());
                    return ResponseEntity.ok(phongHocService.save(ph));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhongHoc(@PathVariable UUID id) {
        if (!phongHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        phongHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
