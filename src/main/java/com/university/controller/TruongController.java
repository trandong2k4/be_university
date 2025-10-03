package com.university.controller;

import com.university.dto.reponse.TruongResponse;
import com.university.dto.request.TruongRequest;
import com.university.service.TruongService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/truongs")
public class TruongController {

    private final TruongService truongService;

    public TruongController(TruongService truongService) {
        this.truongService = truongService;
    }

    @PostMapping
    public ResponseEntity<TruongResponse> create(@RequestBody TruongRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(truongService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TruongResponse>> getAll() {
        return ResponseEntity.ok(truongService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruongResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(truongService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TruongResponse> update(@PathVariable UUID id, @RequestBody TruongRequest request) {
        return ResponseEntity.ok(truongService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        truongService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<TruongResponse>> search(@RequestParam("maTruong") String maTruong) {
        return ResponseEntity.ok(truongService.searchByMaTruong(maTruong));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<TruongResponse>> filterByDiaChi(
            @RequestParam(defaultValue = "") String diaChi,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(truongService.getByDiaChi(diaChi, page, size));
    }
}