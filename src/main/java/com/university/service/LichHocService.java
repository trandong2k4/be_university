package com.university.service;

import com.university.dto.reponse.LichHocResponse;
import com.university.dto.request.LichHocRequest;
import com.university.entity.KiHoc;
import com.university.entity.LichHoc;
import com.university.entity.MonHoc;
import com.university.entity.PhongHoc;
import com.university.mapper.LichHocMapper;
import com.university.repository.KiHocRepository;
import com.university.repository.LichHocRepository;
import com.university.repository.MonHocRepository;
import com.university.repository.PhongHocRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LichHocService {

    private final LichHocRepository lichHocRepository;
    private final PhongHocRepository phongHocRepository;
    private final KiHocRepository kiHocRepository;
    private final MonHocRepository monHocRepository;
    private final LichHocMapper lichHocMapper;

    public LichHocService(LichHocRepository lichHocRepository,
            PhongHocRepository phongHocRepository,
            KiHocRepository kiHocRepository,
            MonHocRepository monHocRepository,
            LichHocMapper lichHocMapper) {
        this.lichHocRepository = lichHocRepository;
        this.phongHocRepository = phongHocRepository;
        this.kiHocRepository = kiHocRepository;
        this.monHocRepository = monHocRepository;
        this.lichHocMapper = lichHocMapper;
    }

    public LichHocResponse create(LichHocRequest request) {
        PhongHoc phong = phongHocRepository.findById(request.getPhongHocId())
                .orElseThrow(() -> new EntityNotFoundException("Phòng học không tồn tại"));
        KiHoc ki = kiHocRepository.findById(request.getKiHocId())
                .orElseThrow(() -> new EntityNotFoundException("Kì học không tồn tại"));
        MonHoc mon = monHocRepository.findById(request.getMonHocId())
                .orElseThrow(() -> new EntityNotFoundException("Môn học không tồn tại"));

        LichHoc lich = lichHocMapper.toEntity(request, phong, ki, mon);
        lich = lichHocRepository.save(lich);
        return lichHocMapper.toResponse(lich);
    }

    public List<LichHocResponse> getAll() {
        return lichHocRepository.findAll().stream()
                .map(lichHocMapper::toResponse)
                .collect(Collectors.toList());
    }
}
