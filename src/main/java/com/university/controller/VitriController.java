package com.university.controller;

import com.university.entity.ViTri;
import com.university.service.VitriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vitris")
public class VitriController {

    @Autowired
    private VitriService vitriService;

    @GetMapping
    public List<ViTri> getAllVitris() {
        return vitriService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViTri> getVitriById(@PathVariable UUID id) {
        return vitriService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ViTri> createVitri(@RequestBody ViTri vitri) {
        if (vitriService.existsByMaViTri(vitri.getMaViTri()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(vitriService.save(vitri));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViTri> updateVitri(@PathVariable UUID id, @RequestBody ViTri vitriDetails) {
        return vitriService.findById(id)
                .map(vitri -> {
                    vitri.setMaViTri(vitriDetails.getMaViTri());
                    vitri.setTenViTri(vitriDetails.getTenViTri());
                    vitri.setMoTa(vitriDetails.getMoTa());
                    vitri.setMucLuongCoBan(vitriDetails.getMucLuongCoBan());
                    return ResponseEntity.ok(vitriService.save(vitri));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitri(@PathVariable UUID id) {
        if (!vitriService.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        vitriService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
