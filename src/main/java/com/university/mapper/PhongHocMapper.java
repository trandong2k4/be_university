package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.PhongHocResponse;
import com.university.dto.request.PhongHocRequest;
import com.university.entity.PhongHoc;

@Component
public class PhongHocMapper {

    public PhongHoc toEntity(PhongHocRequest dto) {
        PhongHoc phong = new PhongHoc();
        phong.setMaPhongHoc(dto.getMaPhongHoc());
        phong.setTenPhong(dto.getTenPhong());
        phong.setToaNha(dto.getToaNha());
        phong.setTang(dto.getTang());
        phong.setSucChua(dto.getSucChua());
        return phong;
    }

    public void updateEntity(PhongHoc phong, PhongHocRequest dto) {
        phong.setMaPhongHoc(dto.getMaPhongHoc());
        phong.setTenPhong(dto.getTenPhong());
        phong.setToaNha(dto.getToaNha());
        phong.setTang(dto.getTang());
        phong.setSucChua(dto.getSucChua());
    }

    public PhongHocResponse toResponse(PhongHoc phong) {
        PhongHocResponse res = new PhongHocResponse();
        res.setId(phong.getId());
        res.setMaPhongHoc(phong.getMaPhongHoc());
        res.setTenPhong(phong.getTenPhong());
        res.setToaNha(phong.getToaNha());
        res.setTang(phong.getTang());
        res.setSucChua(phong.getSucChua());
        res.setSoLichHoc(phong.getLichHocs() != null ? phong.getLichHocs().size() : 0);
        return res;
    }
}
