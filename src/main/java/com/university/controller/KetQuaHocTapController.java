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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.university.dto.reponse.KetQuaHocTapResponseDTO;
import com.university.dto.reponse.RoleResponseDTO;
import com.university.dto.request.KetQuaHocTapRequestDTO;
import com.university.service.KetQuaHocTapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ketquahoctaps")
@RequiredArgsConstructor
public class KetQuaHocTapController {

    private final KetQuaHocTapService ketQuaHocTapService;

    @PostMapping
    public ResponseEntity<KetQuaHocTapResponseDTO> create(@RequestBody @Valid KetQuaHocTapRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ketQuaHocTapService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<KetQuaHocTapResponseDTO>> getAll() {
        return ResponseEntity.ok(ketQuaHocTapService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KetQuaHocTapResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ketQuaHocTapService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<KetQuaHocTapResponseDTO>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(ketQuaHocTapService.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KetQuaHocTapResponseDTO> update(@PathVariable UUID id,
            @RequestBody @Valid KetQuaHocTapRequestDTO dto) {
        return ResponseEntity.ok(ketQuaHocTapService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        ketQuaHocTapService.delete(id);
        return ResponseEntity.noContent().build();
    }
}