package com.university.service;

import com.university.dto.reponse.MonHocResponseDTO;
import com.university.dto.request.MonHocRequestDTO;
import com.university.entity.MonHoc;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.MonHocMapper;
import com.university.repository.MonHocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonHocService {

    private final MonHocRepository monHocRepository;
    private final MonHocMapper monHocMapper;

    public MonHocResponseDTO create(MonHocRequestDTO dto) {
        MonHoc monHoc = monHocMapper.toEntity(dto);
        return monHocMapper.toResponseDTO(monHocRepository.save(monHoc));
    }

    public List<MonHocResponseDTO> getAll() {
        return monHocRepository.findAll().stream()
                .map(monHocMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public MonHocResponseDTO getById(UUID id) {
        MonHoc monHoc = monHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học"));
        return monHocMapper.toResponseDTO(monHoc);
    }

    public MonHocResponseDTO update(UUID id, MonHocRequestDTO dto) {
        MonHoc existing = monHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học"));
        existing.setMaMonHoc(dto.getMaMonHoc());
        existing.setTenMonHoc(dto.getTenMonHoc());
        existing.setMoTa(dto.getMoTa());
        existing.setTongSoTinChi(dto.getTongSoTinChi());
        return monHocMapper.toResponseDTO(monHocRepository.save(existing));
    }

    public void delete(UUID id) {
        monHocRepository.deleteById(id);
    }
}