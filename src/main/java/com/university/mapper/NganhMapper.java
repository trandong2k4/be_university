package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.NganhResponseDTO;
import com.university.dto.request.NganhRequestDTO;
import com.university.entity.Nganh;

@Component
public class NganhMapper {

    public Nganh toEntity(NganhRequestDTO dto) {
        return Nganh.builder()
                .maNganh(dto.getMaNganh())
                .tenNganh(dto.getTenNganh())
                .khoa(dto.getKhoa())
                .build();
    }

    public NganhResponseDTO toResponseDTO(Nganh nganh) {
        return NganhResponseDTO.builder()
                .id(nganh.getId())
                .maNganh(nganh.getMaNganh())
                .tenNganh(nganh.getTenNganh())
                .khoa(nganh.getKhoa())
                .build();
    }
}