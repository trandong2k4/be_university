package com.university.controller;

import com.university.dto.request.HocPhiRequestDTO;
import com.university.dto.response.HocPhiResponseDTO;
import com.university.service.HocPhiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tuition_fees")
@RequiredArgsConstructor
public class HocPhiController {

    private final HocPhiService hocPhiService;

    @PostMapping
    public ResponseEntity<HocPhiResponseDTO> create(@RequestBody @Valid HocPhiRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hocPhiService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<HocPhiResponseDTO>> getAll() {
        return ResponseEntity.ok(hocPhiService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocPhiResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(hocPhiService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HocPhiResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(hocPhiService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocPhiResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid HocPhiRequestDTO dto) {
        return ResponseEntity.ok(hocPhiService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        hocPhiService.delete(id);
        return ResponseEntity.noContent().build();
    }
}