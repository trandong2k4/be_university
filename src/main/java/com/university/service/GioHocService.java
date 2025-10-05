package com.university.service;

import com.university.dto.reponse.GioHocResponseDTO;
import com.university.dto.reponse.TruongResponseDTO;
import com.university.dto.request.GioHocRequestDTO;
import com.university.entity.GioHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.GioHocMapper;
import com.university.repository.GioHocRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GioHocService {

    private final GioHocRepository gioHocRepository;
    private final GioHocMapper gioHocMapper;

    public GioHocResponseDTO create(GioHocRequestDTO dto) {
        GioHoc gioHoc = gioHocMapper.toEntity(dto);
        return gioHocMapper.toResponseDTO(gioHocRepository.save(gioHoc));
    }

    public List<GioHocResponseDTO> getAll() {
        return gioHocRepository.findAll().stream()
                .map(gioHocMapper::toResponseDTO)
                .toList();
    }

    public GioHocResponseDTO getById(UUID id) {
        GioHoc gioHoc = gioHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giờ học"));
        return gioHocMapper.toResponseDTO(gioHoc);
    }

    public List<GioHocResponseDTO> search(String keyword) {
        return gioHocRepository.searchByTenGioHoc(keyword).stream()
                .map(gioHocMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public GioHocResponseDTO update(UUID id, GioHocRequestDTO dto) {
        GioHoc existing = gioHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giờ học"));

        existing.setMaGioHoc(dto.getMaGioHoc());
        existing.setTenGioHoc(dto.getTenGioHoc());
        existing.setThoiGianBatDau(dto.getThoiGianBatDau());
        existing.setThoiGianKetThuc(dto.getThoiGianKetThuc());

        return gioHocMapper.toResponseDTO(gioHocRepository.save(existing));
    }

    public void delete(UUID id) {
        gioHocRepository.deleteById(id);
    }
}