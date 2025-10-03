package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.MonHocResponse;
import com.university.dto.request.MonHocRequest;
import com.university.entity.MonHoc;

@Component
public class MonHocMapper {

    public MonHoc toEntity(MonHocRequest dto) {
        MonHoc entity = new MonHoc();
        entity.setMaMonHoc(dto.getMaMonHoc());
        entity.setTenMonHoc(dto.getTenMonHoc());
        entity.setMoTa(dto.getMoTa());
        entity.setTongSoTinChi(dto.getTongSoTinChi());
        return entity;
    }

    public void updateEntity(MonHoc entity, MonHocRequest dto) {
        entity.setMaMonHoc(dto.getMaMonHoc());
        entity.setTenMonHoc(dto.getTenMonHoc());
        entity.setMoTa(dto.getMoTa());
        entity.setTongSoTinChi(dto.getTongSoTinChi());
    }

    public MonHocResponse toResponse(MonHoc entity) {
        MonHocResponse response = new MonHocResponse();
        response.setId(entity.getId());
        response.setMaMonHoc(entity.getMaMonHoc());
        response.setTenMonHoc(entity.getTenMonHoc());
        response.setMoTa(entity.getMoTa());
        response.setTongSoTinChi(entity.getTongSoTinChi());
        response.setSoTinChiThucTe(entity.getTinChis() != null ? entity.getTinChis().size() : 0);
        return response;
    }
}
