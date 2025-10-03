package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.TruongResponse;
import com.university.dto.request.TruongRequest;
import com.university.entity.Truong;

@Component
public class TruongMapper {

    public Truong toEntity(TruongRequest dto) {
        Truong truong = new Truong();
        truong.setMaTruong(dto.getMaTruong());
        truong.setTenTruong(dto.getTenTruong());
        truong.setDiaChi(dto.getDiaChi());
        truong.setSoDienThoai(dto.getSoDienThoai());
        truong.setEmail(dto.getEmail());
        truong.setWebsite(dto.getWebsite());
        truong.setMoTa(dto.getMoTa());
        truong.setLogoUrl(dto.getLogoUrl());
        truong.setNgayThanhLap(dto.getNgayThanhLap());
        truong.setNguoiDaiDien(dto.getNguoiDaiDien());
        return truong;
    }

    public void updateEntity(Truong truong, TruongRequest dto) {
        truong.setMaTruong(dto.getMaTruong());
        truong.setTenTruong(dto.getTenTruong());
        truong.setDiaChi(dto.getDiaChi());
        truong.setSoDienThoai(dto.getSoDienThoai());
        truong.setEmail(dto.getEmail());
        truong.setWebsite(dto.getWebsite());
        truong.setMoTa(dto.getMoTa());
        truong.setLogoUrl(dto.getLogoUrl());
        truong.setNgayThanhLap(dto.getNgayThanhLap());
        truong.setNguoiDaiDien(dto.getNguoiDaiDien());
    }

    public TruongResponse toResponse(Truong truong) {
        TruongResponse response = new TruongResponse();
        response.setId(truong.getId());
        response.setMaTruong(truong.getMaTruong());
        response.setTenTruong(truong.getTenTruong());
        response.setDiaChi(truong.getDiaChi());
        response.setSoDienThoai(truong.getSoDienThoai());
        response.setEmail(truong.getEmail());
        response.setWebsite(truong.getWebsite());
        response.setMoTa(truong.getMoTa());
        response.setLogoUrl(truong.getLogoUrl());
        response.setNgayThanhLap(truong.getNgayThanhLap());
        response.setNguoiDaiDien(truong.getNguoiDaiDien());
        return response;
    }
}
