package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.SinhVienResponseDTO;
import com.university.dto.request.SinhVienRequestDTO;
import com.university.entity.Nganh;
import com.university.entity.SinhVien;
import com.university.entity.User;

@Component
public class SinhVienMapper {

    public SinhVien toEntity(SinhVienRequestDTO dto, Nganh nganh, User user) {
        return SinhVien.builder()
                .maSinhVien(dto.getMaSinhVien())
                .hoTen(dto.getHoTen())
                .email(dto.getEmail())
                .soDienThoai(dto.getSoDienThoai())
                .ngayNhapHoc(dto.getNgayNhapHoc())
                .ngayTotNghiep(dto.getNgayTotNghiep())
                .nganh(nganh)
                .user(user)
                .build();
    }

    public SinhVienResponseDTO toResponseDTO(SinhVien sv) {
        return SinhVienResponseDTO.builder()
                .id(sv.getId())
                .maSinhVien(sv.getMaSinhVien())
                .hoTen(sv.getHoTen())
                .email(sv.getEmail())
                .soDienThoai(sv.getSoDienThoai())
                .tenNganh(sv.getNganh().getTenNganh())
                .tenKhoa(sv.getNganh().getKhoa().getTenKhoa())
                .tenTruong(sv.getNganh().getKhoa().getTruong().getTenTruong())
                .build();
    }
}
