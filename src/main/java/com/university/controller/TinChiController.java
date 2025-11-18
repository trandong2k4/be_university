package com.university.controller;

import com.university.dto.reponse.TinChiResponse;
import com.university.dto.request.TinChiRequest;
import com.university.service.TinChiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tinchis")
public class TinChiController {

    private final TinChiService tinChiService;

    public TinChiController(TinChiService tinChiService) {
        this.tinChiService = tinChiService;
    }

    @PostMapping
    public ResponseEntity<TinChiResponse> create(@RequestBody TinChiRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tinChiService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TinChiResponse>> getAll() {
        return ResponseEntity.ok(tinChiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TinChiResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(tinChiService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TinChiResponse> update(@PathVariable UUID id, @RequestBody TinChiRequest request) {
        return ResponseEntity.ok(tinChiService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tinChiService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/monhoc")
    public ResponseEntity<List<TinChiResponse>> filterByMonHoc(@RequestParam UUID monHocId) {
        return ResponseEntity.ok(tinChiService.filterByMonHoc(monHocId));
    }

    @GetMapping("/filter/loai")
    public ResponseEntity<List<TinChiResponse>> filterByLoaiTinChi(@RequestParam UUID loaiTinChiId) {
        return ResponseEntity.ok(tinChiService.filterByLoaiTinChi(loaiTinChiId));
    }

    @GetMapping("/filter/giatri")
    public ResponseEntity<List<TinChiResponse>> filterByGiaTri(@RequestParam BigDecimal minGiaTri) {
        return ResponseEntity.ok(tinChiService.filterByGiaTri(minGiaTri));
    }

}