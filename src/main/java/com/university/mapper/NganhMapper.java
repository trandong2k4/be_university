package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.NganhResponseDTO;
import com.university.dto.request.NganhRequestDTO;
import com.university.entity.Khoa;
import com.university.entity.Nganh;
import com.university.repository.KhoaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NganhMapper {

    private final KhoaRepository khoaRepository;

    public Nganh toEntity(NganhRequestDTO dto) {
        Khoa khoa = khoaRepository.findById(dto.getKhoaId())
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy Khoa"));
        return Nganh.builder()
                .maNganh(dto.getMaNganh())
                .tenNganh(dto.getTenNganh())
                .khoa(khoa)
                .build();
    }

    public NganhResponseDTO toResponseDTO(Nganh nganh) {
        return NganhResponseDTO.builder()
                .id(nganh.getId())
                .maNganh(nganh.getMaNganh())
                .tenNganh(nganh.getTenNganh())
                .khoaId(nganh.getKhoa().getId())
                .build();
    }
}
