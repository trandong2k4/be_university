package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.GioHocResponse;
import com.university.dto.request.GioHocRequest;
import com.university.entity.GioHoc;

@Component
public class GioHocMapper {

    public GioHoc toEntity(GioHocRequest dto) {
        GioHoc gio = new GioHoc();
        gio.setMaGioHoc(dto.getMaGioHoc());
        gio.setTenGioHoc(dto.getTenGioHoc());
        gio.setThoiGianBatDau(dto.getThoiGianBatDau());
        gio.setThoiGianKetThuc(dto.getThoiGianKetThuc());
        return gio;
    }

    public GioHocResponse toResponse(GioHoc gioHoc) {
        GioHocResponse res = new GioHocResponse();
        res.setId(gioHoc.getId());
        res.setMaGioHoc(gioHoc.getMaGioHoc());
        res.setTenGioHoc(gioHoc.getTenGioHoc());
        res.setThoiGianBatDau(gioHoc.getThoiGianBatDau());
        res.setThoiGianKetThuc(gioHoc.getThoiGianKetThuc());
        return res;
    }
}
