package com.university.service;

import com.university.dto.request.PhongHocRequestDTO;
import com.university.dto.response.PhongHocResponseDTO;
import com.university.entity.PhongHoc;
import com.university.exception.DuplicateRequestException;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.PhongHocMapper;
import com.university.repository.PhongHocRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhongHocService {

    private final PhongHocRepository phongHocRepository;
    private final PhongHocMapper phongHocMapper;

    public PhongHocResponseDTO create(PhongHocRequestDTO dto) {
        if (phongHocRepository.findByMaPhong(dto.getMaPhong()).isPresent()) {
            throw new DuplicateRequestException("Mã phòng học đã tồn tại");
        }
        PhongHoc phong = phongHocMapper.toEntity(dto);
        return phongHocMapper.toResponseDTO(phongHocRepository.save(phong));
    }

    public List<PhongHocResponseDTO> getAll() {
        return phongHocRepository.findAll().stream()
                .map(phongHocMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PhongHocResponseDTO getById(UUID id) {
        PhongHoc phong = phongHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng học"));
        return phongHocMapper.toResponseDTO(phong);
    }

    public List<PhongHocResponseDTO> search(String keyword) {
        return phongHocRepository.searchByTenPhong(keyword).stream()
                .map(phongHocMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PhongHocResponseDTO update(UUID id, PhongHocRequestDTO dto) {
        PhongHoc existing = phongHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng học"));

        existing.setMaPhong(dto.getMaPhong());
        existing.setTenPhong(dto.getTenPhong());
        existing.setToaNha(dto.getToaNha());
        existing.setTang(dto.getTang());
        existing.setSucChua(dto.getSucChua());

        return phongHocMapper.toResponseDTO(phongHocRepository.save(existing));
    }

    public void delete(UUID id) {
        phongHocRepository.deleteById(id);
    }
}