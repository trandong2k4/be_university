package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.NganhResponse;
import com.university.dto.request.NganhRequest;
import com.university.entity.Khoa;
import com.university.entity.Nganh;

@Component
public class NganhMapper {

    public Nganh toEntity(NganhRequest dto, Khoa khoa) {
        Nganh nganh = new Nganh();
        nganh.setMaNganh(dto.getMaNganh());
        nganh.setTenNganh(dto.getTenNganh());
        nganh.setKhoa(khoa);
        return nganh;
    }

    public void updateEntity(Nganh nganh, NganhRequest dto, Khoa khoa) {
        nganh.setMaNganh(dto.getMaNganh());
        nganh.setTenNganh(dto.getTenNganh());
        nganh.setKhoa(khoa);
    }

    public NganhResponse toResponse(Nganh nganh) {
        NganhResponse response = new NganhResponse();
        response.setId(nganh.getId());
        response.setMaNganh(nganh.getMaNganh());
        response.setTenNganh(nganh.getTenNganh());
        response.setTenKhoa(nganh.getKhoa().getTenKhoa());
        return response;
    }
}