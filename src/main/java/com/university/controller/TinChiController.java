package com.university.controller;

import com.university.dto.request.TinChiRequest;
import com.university.dto.response.TinChiResponseDTO;
import com.university.service.TinChiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/credits")
public class TinChiController {

    private final TinChiService tinChiService;

    public TinChiController(TinChiService tinChiService) {
        this.tinChiService = tinChiService;
    }

    @PostMapping
    public ResponseEntity<TinChiResponseDTO> create(@RequestBody TinChiRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tinChiService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TinChiResponseDTO>> getAll() {
        return ResponseEntity.ok(tinChiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TinChiResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(tinChiService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TinChiResponseDTO> update(@PathVariable UUID id, @RequestBody TinChiRequest request) {
        return ResponseEntity.ok(tinChiService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tinChiService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/subject")
    public ResponseEntity<List<TinChiResponseDTO>> filterByMonHoc(@RequestParam UUID monHocId) {
        return ResponseEntity.ok(tinChiService.filterByMonHoc(monHocId));
    }

    // @GetMapping("/filter/type")
    // public ResponseEntity<List<TinChiResponse>> filterByLoaiTinChi(@RequestParam
    // LoaiTinChiEnum loaiTinChiId) {
    // return ResponseEntity.ok(tinChiService.filterByLoaiTinChi(loaiTinChiId));
    // }

    @GetMapping("/filter/values")
    public ResponseEntity<List<TinChiResponseDTO>> filterByGiaTri(@RequestParam BigDecimal minGiaTri) {
        return ResponseEntity.ok(tinChiService.filterByGiaTri(minGiaTri));
    }

}