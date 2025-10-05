package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.ViTriResponseDTO;
import com.university.dto.request.ViTriRequestDTO;
import com.university.entity.ViTri;

@Component
public class ViTriMapper {

    public ViTri toEntity(ViTriRequestDTO dto) {
        ViTri vt = new ViTri();
        vt.setMaViTri(dto.getMaViTri());
        vt.setTenViTri(dto.getTenViTri());
        vt.setMoTa(dto.getMoTa());
        vt.setMucLuongCoBan(dto.getMucLuongCoBan());
        return vt;
    }

    public ViTriResponseDTO toResponseDTO(ViTri vt) {
        return new ViTriResponseDTO(
                vt.getId(),
                vt.getMaViTri(),
                vt.getTenViTri(),
                vt.getMoTa(),
                vt.getMucLuongCoBan());
    }
}