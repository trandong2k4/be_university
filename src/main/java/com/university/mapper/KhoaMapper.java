package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.KhoaRequestDTO;
import com.university.dto.response.KhoaResponseDTO;
import com.university.entity.Khoa;
import com.university.entity.Truong;

@Component
public class KhoaMapper {

    // Chuyển từ DTO sang Entity
    public Khoa toEntity(KhoaRequestDTO dto, Truong truong) {
        Khoa khoa = new Khoa();
        khoa.setMaKhoa(dto.getMaKhoa());
        khoa.setTenKhoa(dto.getTenKhoa());
        khoa.setTruong(truong);
        return khoa;
    }

    // Chuyển từ Entity sang ResponseDTO
    public KhoaResponseDTO toResponseDTO(Khoa entity) {
        KhoaResponseDTO dto = new KhoaResponseDTO();
        dto.setId(entity.getId());
        dto.setMaKhoa(entity.getMaKhoa());
        dto.setTenKhoa(entity.getTenKhoa());
        dto.setTenTruong(entity.getTruong().getTenTruong());
        return dto;
    }
}
