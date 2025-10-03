package com.university.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.dto.reponse.KetQuaHocTapResponse;
import com.university.dto.request.KetQuaHocTapRequest;
import com.university.service.KetQuaHocTapService;

@RestController
@RequestMapping("/api/ketquahoctaps")
public class KetQuaHocTapController {

    private final KetQuaHocTapService ketQuaHocTapService;

    public KetQuaHocTapController(KetQuaHocTapService ketQuaHocTapService) {
        this.ketQuaHocTapService = ketQuaHocTapService;
    }

    @PostMapping
    public ResponseEntity<KetQuaHocTapResponse> create(@RequestBody KetQuaHocTapRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ketQuaHocTapService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KetQuaHocTapResponse> update(@PathVariable UUID id,
            @RequestBody KetQuaHocTapRequest request) {
        return ResponseEntity.ok(ketQuaHocTapService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KetQuaHocTapResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ketQuaHocTapService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<KetQuaHocTapResponse>> getAll() {
        return ResponseEntity.ok(ketQuaHocTapService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        ketQuaHocTapService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sinhvien/{sinhVienId}")
    public ResponseEntity<List<KetQuaHocTapResponse>> getBySinhVien(@PathVariable UUID sinhVienId) {
        return ResponseEntity.ok(ketQuaHocTapService.getBySinhVienId(sinhVienId));
    }
}
