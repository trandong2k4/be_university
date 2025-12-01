package com.university.controller;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.reponse.LopHocPhanResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.entity.LopHocPhan;
import com.university.service.LichHocService;
import com.university.service.LopHocPhanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class LopHocPhanController {

}
