package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.TruongRequestDTO;
import com.university.dto.response.TruongResponseDTO;
import com.university.entity.Truong;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TruongMapper {

    public Truong toEntity(TruongRequestDTO dto) {
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

    public void updateEntity(Truong truong, TruongRequestDTO dto) {
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

    public TruongResponseDTO toResponseDTO(Truong t) {
        TruongResponseDTO truongResponseDTO = new TruongResponseDTO();
        truongResponseDTO.setId(t.getId());
        truongResponseDTO.setMaTruong(t.getMaTruong());
        truongResponseDTO.setTenTruong(t.getTenTruong());
        truongResponseDTO.setDiaChi(t.getDiaChi());
        truongResponseDTO.setSoDienThoai(t.getSoDienThoai());
        truongResponseDTO.setEmail(t.getEmail());
        truongResponseDTO.setWebsite(t.getWebsite());
        truongResponseDTO.setMoTa(t.getMoTa());
        truongResponseDTO.setLogoUrl(t.getLogoUrl());
        truongResponseDTO.setNgayThanhLap(t.getNgayThanhLap());
        truongResponseDTO.setNguoiDaiDien(t.getNguoiDaiDien());
        return truongResponseDTO;
    }
}
