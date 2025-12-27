package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.GioHocRequestDTO;
import com.university.dto.response.GioHocResponseDTO;
import com.university.entity.GioHoc;

@Component
public class GioHocMapper {

    public GioHoc toEntity(GioHocRequestDTO dto) {
        return GioHoc.builder()
                .maGioHoc(dto.getMaGioHoc())
                .tenGioHoc(dto.getTenGioHoc())
                .thoiGianBatDau(dto.getThoiGianBatDau())
                .thoiGianKetThuc(dto.getThoiGianKetThuc())
                .build();
    }

    public GioHocResponseDTO toResponseDTO(GioHoc gioHoc) {
        return GioHocResponseDTO.builder()
                .id(gioHoc.getId())
                .maGioHoc(gioHoc.getMaGioHoc())
                .tenGioHoc(gioHoc.getTenGioHoc())
                .thoiGianBatDau(gioHoc.getThoiGianBatDau())
                .thoiGianKetThuc(gioHoc.getThoiGianKetThuc())
                .build();
    }
}
