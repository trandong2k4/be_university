package com.university.service;

import com.university.dto.reponse.KiHocResponseDTO;
import com.university.dto.reponse.TruongResponseDTO;
import com.university.dto.request.KiHocRequestDTO;
import com.university.entity.KiHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.KiHocMapper;
import com.university.repository.KiHocRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KiHocService {

    private final KiHocRepository kiHocRepository;
    private final KiHocMapper kiHocMapper;

    public KiHocResponseDTO create(KiHocRequestDTO dto) {
        KiHoc kiHoc = kiHocMapper.toEntity(dto);
        return kiHocMapper.toResponseDTO(kiHocRepository.save(kiHoc));
    }

    public List<KiHocResponseDTO> getAll() {
        return kiHocRepository.findAll().stream()
                .map(kiHocMapper::toResponseDTO)
                .toList();
    }

    public KiHocResponseDTO getById(UUID id) {
        KiHoc kiHoc = kiHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kỳ học"));
        return kiHocMapper.toResponseDTO(kiHoc);
    }

    public List<KiHocResponseDTO> search(String keyword) {
        return kiHocRepository.searchByTenKiHoc(keyword).stream()
                .map(kiHocMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public KiHocResponseDTO update(UUID id, KiHocRequestDTO dto) {
        KiHoc existing = kiHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy kỳ học"));

        existing.setTenKiHoc(dto.getTenKiHoc());
        existing.setNgayBatDau(dto.getNgayBatDau());
        existing.setNgayKetThuc(dto.getNgayKetThuc());
        // existing.setGhiChu(dto.getGhiChu());

        return kiHocMapper.toResponseDTO(kiHocRepository.save(existing));
    }

    public void delete(UUID id) {
        kiHocRepository.deleteById(id);
    }
}