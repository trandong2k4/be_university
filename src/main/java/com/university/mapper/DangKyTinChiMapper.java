package com.university.mapper;

import com.university.dto.response.DangKyTinChiResponseDTO;
import com.university.entity.DangKyTinChi;

public class DangKyTinChiMapper {
    public DangKyTinChi toEntity(DangKyTinChi dto) {
        return DangKyTinChi.builder()
                .sinhVien(dto.getSinhVien())
                .lopHocPhan(dto.getLopHocPhan())
                .build();
    }

    public DangKyTinChiResponseDTO toResponseDTO(DangKyTinChi dto) {
        return DangKyTinChiResponseDTO.builder()
                .id(dto.getId())
                .sinhvienId(dto.getSinhVien().getId())
                .lophocphanId(dto.getLopHocPhan().getId())
                .build();
    }
}
