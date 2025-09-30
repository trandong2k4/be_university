package com.university.controller;

import com.university.entity.TinChi;
import com.university.service.TinChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tinchi")
public class TinChiController {

    @Autowired
    private TinChiService tinChiService;

    @GetMapping
    public List<TinChi> getAllTinChi() {
        return tinChiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TinChi> getTinChiById(@PathVariable UUID id) {
        return tinChiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TinChi> createTinChi(@RequestBody TinChi tinChi) {
        return ResponseEntity.ok(tinChiService.save(tinChi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TinChi> updateTinChi(@PathVariable UUID id, @RequestBody TinChi tinChiDetails) {
        return tinChiService.findById(id)
                .map(tc -> {
                    tc.setSoTinChi(tinChiDetails.getSoTinChi());
                    tc.setGiaTriTinChi(tinChiDetails.getGiaTriTinChi());
                    tc.setTenTinChi(tinChiDetails.getTenTinChi());
                    tc.setLoaiTinChi(tinChiDetails.getLoaiTinChi());
                    tc.setMonHoc(tinChiDetails.getMonHoc());
                    return ResponseEntity.ok(tinChiService.save(tc));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTinChi(@PathVariable UUID id) {
        if (!tinChiService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        tinChiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
