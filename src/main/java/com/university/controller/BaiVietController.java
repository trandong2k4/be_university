package com.university.controller;

import com.university.entity.BaiViet;
import com.university.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/baiviets")
public class BaiVietController {

    @Autowired
    private BaiVietService baiVietService;

    @GetMapping
    public List<BaiViet> getAllBaiViets() {
        return baiVietService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaiViet> getBaiVietById(@PathVariable UUID id) {
        return baiVietService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BaiViet> createBaiViet(@RequestBody BaiViet baiViet) {
        return ResponseEntity.ok(baiVietService.save(baiViet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaiViet> updateBaiViet(@PathVariable UUID id, @RequestBody BaiViet baiVietDetails) {
        return baiVietService.findById(id)
                .map(bv -> {
                    bv.setTieuDe(baiVietDetails.getTieuDe());
                    bv.setNoiDung(baiVietDetails.getNoiDung());
                    bv.setLoaiBaiViet(baiVietDetails.getLoaiBaiViet());
                    bv.setNgayDang(baiVietDetails.getNgayDang());
                    bv.setTacGia(baiVietDetails.getTacGia());
                    bv.setTrangThai(baiVietDetails.getTrangThai());
                    bv.setHinhAnhUrl(baiVietDetails.getHinhAnhUrl());
                    bv.setFileDinhKemUrl(baiVietDetails.getFileDinhKemUrl());
                    bv.setUser(baiVietDetails.getUser());
                    return ResponseEntity.ok(baiVietService.save(bv));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBaiViet(@PathVariable UUID id) {
        if (!baiVietService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        baiVietService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
