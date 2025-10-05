package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.ChiTietSinhVienResponseDTO;
import com.university.dto.request.ChiTietSinhVienRequestDTO;
import com.university.entity.ChiTietSinhVien;
import com.university.entity.SinhVien;

@Component
public class ChiTietSinhVienMapper {

    public ChiTietSinhVien toEntity(ChiTietSinhVienRequestDTO dto, SinhVien sv) {
        return ChiTietSinhVien.builder()
                .diaChi(dto.getDiaChi())
                .ngaySinh(dto.getNgaySinh())
                .gioiTinh(dto.getGioiTinh())
                .quocTich(dto.getQuocTich())
                .cccd(dto.getCccd())
                .sdtNguoiThan(dto.getSdtNguoiThan())
                .sinhVien(sv)
                .build();
    }

    public ChiTietSinhVienResponseDTO toResponseDTO(ChiTietSinhVien ct) {
        return ChiTietSinhVienResponseDTO.builder()
                .id(ct.getId())
                .hoTen(ct.getSinhVien().getHoTen())
                .maSinhVien(ct.getSinhVien().getMaSinhVien())
                .ngaySinh(ct.getNgaySinh())
                .gioiTinh(ct.getGioiTinh())
                .diaChi(ct.getDiaChi())
                .quocTich(ct.getQuocTich())
                .cccd(ct.getCccd())
                .sdtNguoiThan(ct.getSdtNguoiThan())
                .build();
    }
}