package com.university.controller;

import com.university.dto.reponse.ViTriResponse;
import com.university.dto.request.ViTriRequest;
import com.university.service.ViTriService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vitris")
public class ViTriController {

    private final ViTriService viTriService;

    public ViTriController(ViTriService viTriService) {
        this.viTriService = viTriService;
    }

    @PostMapping
    public ResponseEntity<ViTriResponse> create(@RequestBody ViTriRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(viTriService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ViTriResponse>> getAll() {
        return ResponseEntity.ok(viTriService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViTriResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(viTriService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViTriResponse> update(@PathVariable UUID id, @RequestBody ViTriRequest request) {
        return ResponseEntity.ok(viTriService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        viTriService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ViTriResponse>> search(@RequestParam("tenViTri") String tenViTri) {
        return ResponseEntity.ok(viTriService.searchByTenViTri(tenViTri));
    }
}
