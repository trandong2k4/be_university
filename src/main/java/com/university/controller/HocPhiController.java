package com.university.controller;

import com.university.dto.reponse.HocPhiResponse;
import com.university.dto.request.HocPhiRequest;
import com.university.service.HocPhiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hocphis")
public class HocPhiController {

    private final HocPhiService hocPhiService;

    public HocPhiController(HocPhiService hocPhiService) {
        this.hocPhiService = hocPhiService;
    }

    @PostMapping
    public ResponseEntity<HocPhiResponse> create(@RequestBody HocPhiRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hocPhiService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocPhiResponse> update(@PathVariable UUID id, @RequestBody HocPhiRequest request) {
        return ResponseEntity.ok(hocPhiService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocPhiResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(hocPhiService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<HocPhiResponse>> getAll() {
        return ResponseEntity.ok(hocPhiService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        hocPhiService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/trangthai")
    public ResponseEntity<List<HocPhiResponse>> filterByTrangThai(@RequestParam String trangThai) {
        return ResponseEntity.ok(hocPhiService.filterByTrangThai(trangThai));
    }

    @GetMapping("/filter/kihoc")
    public ResponseEntity<List<HocPhiResponse>> filterByKiHoc(@RequestParam UUID kiHocId) {
        return ResponseEntity.ok(hocPhiService.filterByKiHoc(kiHocId));
    }

    @GetMapping("/filter/sinhvien")
    public ResponseEntity<List<HocPhiResponse>> filterBySinhVien(@RequestParam UUID sinhVienId) {
        return ResponseEntity.ok(hocPhiService.filterBySinhVien(sinhVienId));
    }

    @GetMapping("/filter/trehan")
    public ResponseEntity<List<HocPhiResponse>> filterTreHanChuaThanhToan(@RequestParam LocalDate beforeDate) {
        return ResponseEntity.ok(hocPhiService.filterTreHanChuaThanhToan(beforeDate));
    }
}