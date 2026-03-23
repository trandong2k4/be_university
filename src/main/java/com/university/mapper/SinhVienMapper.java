package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.SinhVienRequestDTO;
import com.university.dto.response.SinhVienAdminResponseDTO;
import com.university.dto.response.SinhVienResponseDTO;
import com.university.entity.SinhVien;
import com.university.entity.Khoa;
import com.university.entity.Nganh;
import com.university.entity.Truong;
import com.university.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SinhVienMapper {

    public SinhVien toEntity(SinhVienRequestDTO dto, Nganh nganh, User user) {
        return SinhVien.builder()
                .maSinhVien(dto.getMaSinhVien())
                .hoTen(dto.getHoTen())
                .soDienThoai(dto.getSoDienThoai())
                .ngayNhapHoc(dto.getNgayNhapHoc())
                .ngayTotNghiep(dto.getNgayTotNghiep())
                .nganh(nganh)
                .user(user)
                .build();
    }

    public SinhVienResponseDTO toResponseDTO(SinhVien sv) {
        Nganh nganh = sv.getNganh();
        Khoa khoa = nganh.getKhoa();
        Truong truong = khoa.getTruong();
        return SinhVienResponseDTO.builder()
                .id(sv.getId())
                .maSinhVien(sv.getMaSinhVien())
                .hoTen(sv.getHoTen())
                .soDienThoai(sv.getSoDienThoai())
                .ngayNhapHoc(sv.getNgayNhapHoc())
                .ngayTotNghiep(sv.getNgayTotNghiep())
                .tenNganh(nganh.getTenNganh())
                .tenKhoa(khoa.getTenKhoa())
                .tenTruong(truong.getTenTruong())
                .build();
    }

    public SinhVienAdminResponseDTO toResponseAdminDTO(SinhVien hv) {
        return SinhVienAdminResponseDTO.builder()
                .id(hv.getId())
                .maSinhVien(hv.getMaSinhVien())
                .hoTen(hv.getHoTen())
                .soDienThoai(hv.getSoDienThoai())
                .ngayNhapHoc(hv.getNgayNhapHoc())
                .ngayTotNghiep(hv.getNgayTotNghiep())
                .nganhId(hv.getNganh().getId())
                .tenNganh(hv.getNganh().getTenNganh())
                .build();
    }
}
