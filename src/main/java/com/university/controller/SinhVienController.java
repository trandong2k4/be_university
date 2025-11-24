package com.university.controller;

import com.university.dto.reponse.SinhVienResponseDTO;
import com.university.dto.request.SinhVienRequestDTO;
import com.university.service.SinhVienService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class SinhVienController {

    private final SinhVienService sinhVienService;

    // 🔹 Lấy tất cả sinh viên
    @GetMapping
    public ResponseEntity<List<SinhVienResponseDTO>> getAll() {
        return ResponseEntity.ok(sinhVienService.getAll());
    }

    // 🔹 Lấy theo ID
    @GetMapping("/{id}")
    public ResponseEntity<SinhVienResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(sinhVienService.getById(id));
    }

    // ✅ GET /api/sinhviens/by-user/{userId}
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<SinhVienResponseDTO> getByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(sinhVienService.findByUserId(userId));
    }

    // 🔹 Tìm kiếm theo từ khóa
    @GetMapping("/search")
    public ResponseEntity<List<SinhVienResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(sinhVienService.search(keyword));
    }

    // 🔹 Tạo mới sinh viên
    @PostMapping
    public ResponseEntity<SinhVienResponseDTO> create(@RequestBody @Valid SinhVienRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sinhVienService.create(dto));
    }

    // 🔹 Cập nhật sinh viên
    @PutMapping("/{id}")
    public ResponseEntity<SinhVienResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid SinhVienRequestDTO dto) {
        return ResponseEntity.ok(sinhVienService.update(id, dto));
    }

    // 🔹 Xóa sinh viên
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        sinhVienService.delete(id);
        return ResponseEntity.noContent().build();
    }
}