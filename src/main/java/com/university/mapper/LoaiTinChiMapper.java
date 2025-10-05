package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.LoaiTinChiResponseDTO;
import com.university.dto.request.LoaiTinChiRequestDTO;
import com.university.entity.LoaiTinChi;

@Component
public class LoaiTinChiMapper {

    public LoaiTinChi toEntity(LoaiTinChiRequestDTO dto) {
        return LoaiTinChi.builder()
                .maLoaiTinChi(dto.getMaLoaiTinChi())
                .tenLoaiTinChi(dto.getTenLoaiTinChi())
                .build();
    }

    public LoaiTinChiResponseDTO toResponseDTO(LoaiTinChi entity) {
        return LoaiTinChiResponseDTO.builder()
                .id(entity.getId())
                .maLoaiTinChi(entity.getMaLoaiTinChi())
                .tenLoaiTinChi(entity.getTenLoaiTinChi())
                .build();
    }
}