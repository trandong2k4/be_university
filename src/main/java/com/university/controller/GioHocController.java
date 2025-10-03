package com.university.controller;

import com.university.dto.reponse.GioHocResponse;
import com.university.dto.request.GioHocRequest;
import com.university.service.GioHocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/giohocs")
public class GioHocController {

    private final GioHocService gioHocService;

    public GioHocController(GioHocService gioHocService) {
        this.gioHocService = gioHocService;
    }

    @PostMapping
    public ResponseEntity<GioHocResponse> create(@RequestBody GioHocRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gioHocService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<GioHocResponse>> getAll() {
        return ResponseEntity.ok(gioHocService.getAll());
    }
}
