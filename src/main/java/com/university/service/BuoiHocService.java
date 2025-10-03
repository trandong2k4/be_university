package com.university.service;

import com.university.dto.reponse.BuoiHocResponse;
import com.university.dto.request.BuoiHocRequest;
import com.university.entity.BuoiHoc;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;
import com.university.mapper.BuoiHocMapper;
import com.university.repository.BuoiHocRepository;
import com.university.repository.GioHocRepository;
import com.university.repository.LichHocRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuoiHocService {

    private final BuoiHocRepository buoiHocRepository;
    private final GioHocRepository gioHocRepository;
    private final LichHocRepository lichHocRepository;
    private final BuoiHocMapper buoiHocMapper;

    public BuoiHocService(BuoiHocRepository buoiHocRepository,
            GioHocRepository gioHocRepository,
            LichHocRepository lichHocRepository,
            BuoiHocMapper buoiHocMapper) {
        this.buoiHocRepository = buoiHocRepository;
        this.gioHocRepository = gioHocRepository;
        this.lichHocRepository = lichHocRepository;
        this.buoiHocMapper = buoiHocMapper;
    }

    public BuoiHocResponse create(BuoiHocRequest request) {
        GioHoc gio = gioHocRepository.findById(request.getGioHocId())
                .orElseThrow(() -> new EntityNotFoundException("Giờ học không tồn tại"));
        LichHoc lich = lichHocRepository.findById(request.getLichHocId())
                .orElseThrow(() -> new EntityNotFoundException("Lịch học không tồn tại"));

        BuoiHoc buoi = buoiHocMapper.toEntity(request, gio, lich);
        buoi = buoiHocRepository.save(buoi);
        return buoiHocMapper.toResponse(buoi);
    }

    public List<BuoiHocResponse> getAll() {
        return buoiHocRepository.findAll().stream()
                .map(buoiHocMapper::toResponse)
                .collect(Collectors.toList());
    }
}