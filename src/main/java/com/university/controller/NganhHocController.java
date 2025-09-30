package com.university.controller;

import com.university.entity.NganhHoc;
import com.university.service.NganhHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nganhhocs")
public class NganhHocController {

    @Autowired
    private NganhHocService nganhHocService;

    @GetMapping
    public List<NganhHoc> getAllNganhHocs() {
        return nganhHocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NganhHoc> getNganhHocById(@PathVariable UUID id) {
        return nganhHocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NganhHoc> createNganhHoc(@RequestBody NganhHoc nganhHoc) {
        if (nganhHocService.existsByMaNganh(nganhHoc.getMaNganh()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(nganhHocService.save(nganhHoc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NganhHoc> updateNganhHoc(@PathVariable UUID id, @RequestBody NganhHoc nganhHocDetails) {
        return nganhHocService.findById(id)
                .map(nganhHoc -> {
                    nganhHoc.setMaNganh(nganhHocDetails.getMaNganh());
                    nganhHoc.setMaNganh(nganhHocDetails.getTenNganh());
                    nganhHoc.setKhoa(nganhHocDetails.getKhoa());
                    return ResponseEntity.ok(nganhHocService.save(nganhHoc));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNganhHoc(@PathVariable UUID id) {
        if (!nganhHocService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        nganhHocService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
