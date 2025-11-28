package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.NhanVienResponseDTO;
import com.university.dto.request.NhanVienRequestDTO;
import com.university.entity.NhanVien;
import com.university.entity.User;
import com.university.entity.ViTri;

@Component
public class NhanVienMapper {

    public NhanVien toEntity(NhanVienRequestDTO dto, ViTri viTri, User user) {
        NhanVien nv = new NhanVien();
        nv.setHoTen(dto.getHoTen());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setNgayNghiViec(dto.getNgayNghiViec());
        nv.setViTri(viTri);
        nv.setUser(user);
        return nv;
    }

    public NhanVienResponseDTO toResponseDTO(NhanVien nv) {
        return new NhanVienResponseDTO(
                nv.getId(),
                nv.getHoTen(),
                nv.getSoDienThoai(),
                nv.getNgayVaoLam(),
                nv.getNgayNghiViec(),
                nv.getViTri() != null ? nv.getViTri().getTenViTri() : null,
                nv.getUser() != null ? nv.getUser().getUsername() : null);
    }
}