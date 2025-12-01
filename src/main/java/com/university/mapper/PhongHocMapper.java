package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.PhongHocResponseDTO;
import com.university.dto.request.PhongHocRequestDTO;
import com.university.entity.PhongHoc;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PhongHocMapper {

    public PhongHoc toEntity(PhongHocRequestDTO dto) {
        return PhongHoc.builder()
                .maPhong(dto.getMaPhong())
                .tenPhong(dto.getTenPhong())
                .toaNha(dto.getToaNha())
                .tang(dto.getTang())
                .sucChua(dto.getSucChua())
                .build();
    }

    public PhongHocResponseDTO toResponseDTO(PhongHoc entity) {
        return PhongHocResponseDTO.builder()
                .id(entity.getId())
                .maPhong(entity.getMaPhong())
                .tenPhong(entity.getTenPhong())
                .toaNha(entity.getToaNha())
                .tang(entity.getTang())
                .sucChua(entity.getSucChua())
                .build();
    }
}