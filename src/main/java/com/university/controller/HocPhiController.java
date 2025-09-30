package com.university.controller;

import com.university.entity.HocPhi;
import com.university.service.HocPhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hocphis")
public class HocPhiController {

    @Autowired
    private HocPhiService hocPhiService;

    @GetMapping
    public List<HocPhi> getAllHocPhis() {
        return hocPhiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocPhi> getHocPhiById(@PathVariable UUID id) {
        return hocPhiService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HocPhi> createHocPhi(@RequestBody HocPhi hocPhi) {
        return ResponseEntity.ok(hocPhiService.save(hocPhi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocPhi> updateHocPhi(@PathVariable UUID id, @RequestBody HocPhi hocPhiDetails) {
        return hocPhiService.findById(id)
                .map(hp -> {
                    hp.setSinhVien(hocPhiDetails.getSinhVien());
                    hp.setKiHoc(hocPhiDetails.getKiHoc());
                    hp.setSoTien(hocPhiDetails.getSoTien());
                    hp.setGiaTriTinChi(hocPhiDetails.getGiaTriTinChi());
                    hp.setNgayTao(hocPhiDetails.getNgayTao());
                    hp.setHanThanhToan(hocPhiDetails.getHanThanhToan());
                    hp.setNgayThanhToan(hocPhiDetails.getNgayThanhToan());
                    hp.setTrangThai(hocPhiDetails.getTrangThai());
                    hp.setGhiChu(hocPhiDetails.getGhiChu());
                    return ResponseEntity.ok(hocPhiService.save(hp));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHocPhi(@PathVariable UUID id) {
        if (!hocPhiService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        hocPhiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
