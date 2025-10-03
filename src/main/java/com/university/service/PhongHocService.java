package com.university.service;

import com.university.dto.reponse.PhongHocResponse;
import com.university.dto.request.PhongHocRequest;
import com.university.entity.PhongHoc;
import com.university.mapper.PhongHocMapper;
import com.university.repository.PhongHocRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PhongHocService {

    private final PhongHocRepository phongHocRepository;
    private final PhongHocMapper phongHocMapper;

    public PhongHocService(PhongHocRepository phongHocRepository, PhongHocMapper phongHocMapper) {
        this.phongHocRepository = phongHocRepository;
        this.phongHocMapper = phongHocMapper;
    }

    public PhongHocResponse create(PhongHocRequest request) {
        PhongHoc phong = phongHocMapper.toEntity(request);
        phong = phongHocRepository.save(phong);
        return phongHocMapper.toResponse(phong);
    }

    public List<PhongHocResponse> getAll() {
        return phongHocRepository.findAll().stream()
                .map(phongHocMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PhongHocResponse getById(UUID id) {
        PhongHoc phong = phongHocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Phòng học không tồn tại"));
        return phongHocMapper.toResponse(phong);
    }

    public PhongHocResponse update(UUID id, PhongHocRequest request) {
        PhongHoc phong = phongHocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Phòng học không tồn tại"));
        phongHocMapper.updateEntity(phong, request);
        phong = phongHocRepository.save(phong);
        return phongHocMapper.toResponse(phong);
    }

    public void delete(UUID id) {
        if (!phongHocRepository.existsById(id)) {
            throw new EntityNotFoundException("Phòng học không tồn tại");
        }
        phongHocRepository.deleteById(id);
    }

    public List<PhongHocResponse> searchByToaNha(String keyword) {
        return phongHocRepository.findByToaNhaContainingIgnoreCase(keyword).stream()
                .map(phongHocMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<PhongHocResponse> filterByTangAndSucChua(Integer tang, Integer sucChua) {
        List<PhongHoc> phongHocs = phongHocRepository.findByTangAndSucChuaGreaterThanEqual(tang, sucChua);
        return phongHocs.stream().map(phongHocMapper::toResponse).collect(Collectors.toList());
    }
}