package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.NhanVienRequestDTO;
import com.university.dto.response.NhanVienResponseDTO;
import com.university.entity.NhanVien;
import com.university.entity.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NhanVienMapper {

    public NhanVien toEntity(NhanVienRequestDTO dto, User user) {
        NhanVien nv = new NhanVien();
        nv.setHoTen(dto.getHoTen());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setNgayNghiViec(dto.getNgayNghiViec());
        nv.setViTri(dto.getViTri());
        nv.setUser(user);
        return nv;
    }

    public NhanVienResponseDTO toResponseDTO(NhanVien nv) {
        NhanVienResponseDTO nhanVienResponseDTO = new NhanVienResponseDTO();
        nhanVienResponseDTO.setId(nv.getId());
        nhanVienResponseDTO.setMaNhanVien(nv.getMaNhanVien());
        nhanVienResponseDTO.setHoTen(nv.getHoTen());
        nhanVienResponseDTO.setNgayNghiViec(nv.getNgayNghiViec());
        nhanVienResponseDTO.setNgayVaoLam(nv.getNgayVaoLam());
        nhanVienResponseDTO.setSoDienThoai(nv.getSoDienThoai());
        nhanVienResponseDTO.setTenNguoiDung("Chua set");
        nhanVienResponseDTO.setViTri(nv.getViTri());

        return nhanVienResponseDTO;
    }
}