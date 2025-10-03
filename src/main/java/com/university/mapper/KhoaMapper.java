package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.KhoaResponse;
import com.university.dto.request.KhoaRequest;
import com.university.entity.Khoa;
import com.university.entity.Truong;

@Component
public class KhoaMapper {

    public Khoa toEntity(KhoaRequest dto, Truong truong) {
        Khoa khoa = new Khoa();
        khoa.setMaKhoa(dto.getMaKhoa());
        khoa.setTenKhoa(dto.getTenKhoa());
        khoa.setTruong(truong);
        return khoa;
    }

    public void updateEntity(Khoa khoa, KhoaRequest dto, Truong truong) {
        khoa.setMaKhoa(dto.getMaKhoa());
        khoa.setTenKhoa(dto.getTenKhoa());
        khoa.setTruong(truong);
    }

    public KhoaResponse toResponse(Khoa khoa) {
        KhoaResponse response = new KhoaResponse();
        response.setId(khoa.getId());
        response.setMaKhoa(khoa.getMaKhoa());
        response.setTenKhoa(khoa.getTenKhoa());
        response.setTenTruong(khoa.getTruong().getTenTruong());
        return response;
    }
}
