package com.university.mapper;

import org.springframework.stereotype.Component;
import com.university.dto.reponse.KiHocResponseDTO;
import com.university.dto.request.KiHocRequestDTO;
import com.university.entity.KiHoc;

@Component
public class KiHocMapper {

    public KiHoc toEntity(KiHocRequestDTO dto) {
        return KiHoc.builder()
                .tenKiHoc(dto.getTenKiHoc())
                .ngayBatDau(dto.getNgayBatDau())
                .ngayKetThuc(dto.getNgayKetThuc())
                // .ghiChu(dto.getGhiChu())
                .build();
    }

    public KiHocResponseDTO toResponseDTO(KiHoc kiHoc) {
        return KiHocResponseDTO.builder()
                .id(kiHoc.getId())
                .tenKiHoc(kiHoc.getTenKiHoc())
                .ngayBatDau(kiHoc.getNgayBatDau())
                .ngayKetThuc(kiHoc.getNgayKetThuc())
                // .ghiChu(kiHoc.getGhiChu())
                .build();
    }
}