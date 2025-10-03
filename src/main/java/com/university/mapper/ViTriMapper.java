package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.ViTriResponse;
import com.university.dto.request.ViTriRequest;
import com.university.entity.ViTri;

@Component
public class ViTriMapper {

    public ViTri toEntity(ViTriRequest dto) {
        ViTri viTri = new ViTri();
        viTri.setMaViTri(dto.getMaViTri());
        viTri.setTenViTri(dto.getTenViTri());
        viTri.setMoTa(dto.getMoTa());
        viTri.setMucLuongCoBan(dto.getMucLuongCoBan());
        return viTri;
    }

    public void updateEntity(ViTri viTri, ViTriRequest dto) {
        viTri.setMaViTri(dto.getMaViTri());
        viTri.setTenViTri(dto.getTenViTri());
        viTri.setMoTa(dto.getMoTa());
        viTri.setMucLuongCoBan(dto.getMucLuongCoBan());
    }

    public ViTriResponse toResponse(ViTri viTri) {
        ViTriResponse res = new ViTriResponse();
        res.setId(viTri.getId());
        res.setMaViTri(viTri.getMaViTri());
        res.setTenViTri(viTri.getTenViTri());
        res.setMoTa(viTri.getMoTa());
        res.setMucLuongCoBan(viTri.getMucLuongCoBan());
        res.setSoLuongNhanVien(viTri.getNhanViens() != null ? viTri.getNhanViens().size() : 0);
        return res;
    }
}
