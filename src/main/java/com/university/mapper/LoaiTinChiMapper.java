package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.LoaiTinChiResponse;
import com.university.dto.request.LoaiTinChiRequest;
import com.university.entity.LoaiTinChi;

@Component
public class LoaiTinChiMapper {

    public LoaiTinChi toEntity(LoaiTinChiRequest dto) {
        LoaiTinChi entity = new LoaiTinChi();
        entity.setMaLoaiTinChi(dto.getMaLoaiTinChi());
        entity.setTenLoaiTinChi(dto.getTenLoaiTinChi());
        return entity;
    }

    public void updateEntity(LoaiTinChi entity, LoaiTinChiRequest dto) {
        entity.setMaLoaiTinChi(dto.getMaLoaiTinChi());
        entity.setTenLoaiTinChi(dto.getTenLoaiTinChi());
    }

    public LoaiTinChiResponse toResponse(LoaiTinChi entity) {
        LoaiTinChiResponse response = new LoaiTinChiResponse();
        response.setId(entity.getId());
        response.setMaLoaiTinChi(entity.getMaLoaiTinChi());
        response.setTenLoaiTinChi(entity.getTenLoaiTinChi());
        response.setSoLuongTinChi(entity.getTinChis() != null ? entity.getTinChis().size() : 0);
        return response;
    }
}
