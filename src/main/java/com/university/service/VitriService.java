package com.university.service;

import com.university.dto.reponse.ViTriResponseDTO;
import com.university.dto.request.ViTriRequestDTO;
import com.university.entity.ViTri;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.ViTriMapper;
import com.university.repository.ViTriRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ViTriService {

    private final ViTriRepository viTriRepository;
    private final ViTriMapper viTriMapper;

    public ViTriResponseDTO create(ViTriRequestDTO dto) {
        ViTri vt = viTriMapper.toEntity(dto);
        return viTriMapper.toResponseDTO(viTriRepository.save(vt));
    }

    public ViTriResponseDTO getById(UUID id) {
        ViTri vt = viTriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy vị trí"));
        return viTriMapper.toResponseDTO(vt);
    }

    public List<ViTriResponseDTO> getAll() {
        return viTriRepository.findAll().stream()
                .map(viTriMapper::toResponseDTO)
                .toList();
    }

    public List<ViTriResponseDTO> search(String keyword) {
        return viTriRepository
                .findByMaViTriContainingIgnoreCaseOrTenViTriContainingIgnoreCase(keyword, keyword)
                .stream().map(viTriMapper::toResponseDTO)
                .toList();
    }

    public ViTriResponseDTO update(UUID id, ViTriRequestDTO dto) {
        ViTri vt = viTriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy vị trí"));
        vt.setMaViTri(dto.getMaViTri());
        vt.setTenViTri(dto.getTenViTri());
        vt.setMoTa(dto.getMoTa());
        vt.setMucLuongCoBan(dto.getMucLuongCoBan());
        return viTriMapper.toResponseDTO(viTriRepository.save(vt));
    }

    public void delete(UUID id) {
        viTriRepository.deleteById(id);
    }
}