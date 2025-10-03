package com.university.controller;

import com.university.dto.reponse.LichHocResponse;
import com.university.dto.request.LichHocRequest;
import com.university.service.LichHocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lichhocs")
public class LichHocController {

    private final LichHocService lichHocService;

    public LichHocController(LichHocService lichHocService) {
        this.lichHocService = lichHocService;
    }

    @PostMapping
    public ResponseEntity<LichHocResponse> create(@RequestBody LichHocRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lichHocService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<LichHocResponse>> getAll() {
        return ResponseEntity.ok(lichHocService.getAll());
    }
}