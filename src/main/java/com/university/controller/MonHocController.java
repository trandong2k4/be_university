package com.university.controller;

import com.university.entity.MonHoc;
import com.university.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/monhocs")
public class MonHocController {

    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public List<MonHoc> getAllMonHocs() {
        return monHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonHoc> getMonHocById(@PathVariable UUID id) {
        return monHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MonHoc> createMonHoc(@RequestBody MonHoc monHoc) {
        if (monHocService.existsByMaMonHoc(monHoc.getMaMonHoc()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(monHocService.save(monHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonHoc> updateMonHoc(@PathVariable UUID id, @RequestBody MonHoc monHocDetails) {
        return monHocService.findById(id)
                .map(monHoc -> {
                    monHoc.setMaMonHoc(monHocDetails.getMaMonHoc());
                    monHoc.setTenMonHoc(monHocDetails.getTenMonHoc());
                    monHoc.setMoTa(monHocDetails.getMoTa());
                    monHoc.setTongSoTinChi(monHocDetails.getTongSoTinChi());
                    return ResponseEntity.ok(monHocService.save(monHoc));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonHoc(@PathVariable UUID id) {
        if (!monHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        monHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
