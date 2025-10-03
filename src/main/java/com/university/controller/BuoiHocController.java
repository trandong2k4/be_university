package com.university.controller;

import com.university.dto.reponse.BuoiHocResponse;
import com.university.dto.request.BuoiHocRequest;
import com.university.service.BuoiHocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/buoihocs")
public class BuoiHocController {

    private final BuoiHocService buoiHocService;

    public BuoiHocController(BuoiHocService buoiHocService) {
        this.buoiHocService = buoiHocService;
    }

    @PostMapping
    public ResponseEntity<BuoiHocResponse> create(@RequestBody BuoiHocRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(buoiHocService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<BuoiHocResponse>> getAll() {
        return ResponseEntity.ok(buoiHocService.getAll());
    }
}
