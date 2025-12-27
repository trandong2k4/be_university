package com.university.controller;

import com.university.dto.request.LopHocPhanRequestDTO;
import com.university.dto.response.LopHocPhanResponseDTO;
import com.university.service.LopHocPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LopHocPhanController {

    private final LopHocPhanService lopHocPhanService;

    @PostMapping
    public ResponseEntity<LopHocPhanResponseDTO> create(@RequestBody LopHocPhanRequestDTO dto) {
        return ResponseEntity.ok(lopHocPhanService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<LopHocPhanResponseDTO>> getAll() {
        return ResponseEntity.ok(lopHocPhanService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LopHocPhanResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(lopHocPhanService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LopHocPhanResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody LopHocPhanRequestDTO dto) {
        return ResponseEntity.ok(lopHocPhanService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        lopHocPhanService.delete(id);
        return ResponseEntity.ok("Đã xóa lớp học phần!");
    }
}
