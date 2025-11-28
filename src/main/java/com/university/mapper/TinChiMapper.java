package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.TinChiResponse;
import com.university.dto.request.TinChiRequest;
import com.university.entity.MonHoc;
import com.university.entity.TinChi;

@Component
public class TinChiMapper {

    public TinChi toEntity(TinChiRequest dto, MonHoc monHoc) {
        TinChi entity = new TinChi();
        entity.setSoTinChi(dto.getSoTinChi());
        entity.setGiaTriTinChi(dto.getGiaTriTinChi());
        entity.setLoaiTinChi(dto.getLoaiTinChiId());
        entity.setMonHoc(monHoc);
        return entity;
    }

    public void updateEntity(TinChi entity, TinChiRequest dto, MonHoc monHoc) {
        entity.setSoTinChi(dto.getSoTinChi());
        entity.setGiaTriTinChi(dto.getGiaTriTinChi());
        entity.setLoaiTinChi(entity.getLoaiTinChi());
        entity.setMonHoc(monHoc);
    }

    public TinChiResponse toResponse(TinChi entity) {
        TinChiResponse response = new TinChiResponse();
        response.setId(entity.getId());
        response.setSoTinChi(entity.getSoTinChi());
        response.setGiaTriTinChi(entity.getGiaTriTinChi());
        response.setTenLoaiTinChi(entity.getLoaiTinChi());
        response.setTenMonHoc(entity.getMonHoc().getTenMonHoc());
        return response;
    }
}
