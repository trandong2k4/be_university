package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.TinChiRequest;
import com.university.dto.response.TinChiResponseDTO;
import com.university.entity.MonHoc;
import com.university.entity.TinChi;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
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

    public TinChiResponseDTO toResponse(TinChi entity) {
        TinChiResponseDTO response = new TinChiResponseDTO();
        response.setId(entity.getId());
        response.setSoTinChi(entity.getSoTinChi());
        response.setGiaTriTinChi(entity.getGiaTriTinChi());
        response.setTenLoaiTinChi(entity.getLoaiTinChi());
        response.setTenMonHoc(entity.getMonHoc().getTenMonHoc());
        return response;
    }
}
