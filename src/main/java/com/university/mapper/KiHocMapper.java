package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.KiHocRequest;
import com.university.dto.request.KiHocResponse;
import com.university.entity.KiHoc;

@Component
public class KiHocMapper {

    public KiHoc toEntity(KiHocRequest dto) {
        KiHoc entity = new KiHoc();
        entity.setMaKiHoc(dto.getMaKiHoc());
        entity.setTenKiHoc(dto.getTenKiHoc());
        entity.setNgayBatDau(dto.getNgayBatDau());
        entity.setNgayKetThuc(dto.getNgayKetThuc());
        return entity;
    }

    public void updateEntity(KiHoc entity, KiHocRequest dto) {
        entity.setMaKiHoc(dto.getMaKiHoc());
        entity.setTenKiHoc(dto.getTenKiHoc());
        entity.setNgayBatDau(dto.getNgayBatDau());
        entity.setNgayKetThuc(dto.getNgayKetThuc());
    }

    public KiHocResponse toResponse(KiHoc entity) {
        KiHocResponse response = new KiHocResponse();
        response.setId(entity.getId());
        response.setMaKiHoc(entity.getMaKiHoc());
        response.setTenKiHoc(entity.getTenKiHoc());
        response.setNgayBatDau(entity.getNgayBatDau());
        response.setNgayKetThuc(entity.getNgayKetThuc());
        response.setSoLichHoc(entity.getLichHocs() != null ? entity.getLichHocs().size() : 0);
        response.setSoHocPhi(entity.getHocPhis() != null ? entity.getHocPhis().size() : 0);
        response.setSoHocLai(entity.getHocLais() != null ? entity.getHocLais().size() : 0);
        return response;
    }
}