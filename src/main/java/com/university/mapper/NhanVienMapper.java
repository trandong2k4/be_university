package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.NhanVienResponse;
import com.university.dto.request.NhanVienRequest;
import com.university.entity.NhanVien;
import com.university.entity.User;
import com.university.entity.ViTri;

@Component
public class NhanVienMapper {

    public NhanVien toEntity(NhanVienRequest dto, ViTri viTri, User user) {
        NhanVien nv = new NhanVien();
        nv.setHoTen(dto.getHoTen());
        nv.setEmail(dto.getEmail());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setNgayNghiViec(dto.getNgayNghiViec());
        nv.setViTri(viTri);
        nv.setUser(user);
        return nv;
    }

    public void updateEntity(NhanVien nv, NhanVienRequest dto, ViTri viTri, User user) {
        nv.setHoTen(dto.getHoTen());
        nv.setEmail(dto.getEmail());
        nv.setSoDienThoai(dto.getSoDienThoai());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setNgayNghiViec(dto.getNgayNghiViec());
        nv.setViTri(viTri);
        nv.setUser(user);
    }

    public NhanVienResponse toResponse(NhanVien nv) {
        NhanVienResponse res = new NhanVienResponse();
        res.setId(nv.getId());
        res.setHoTen(nv.getHoTen());
        res.setEmail(nv.getEmail());
        res.setSoDienThoai(nv.getSoDienThoai());
        res.setNgayVaoLam(nv.getNgayVaoLam());
        res.setNgayNghiViec(nv.getNgayNghiViec());
        res.setTenViTri(nv.getViTri() != null ? nv.getViTri().getTenViTri() : null);
        res.setUsername(nv.getUser() != null ? nv.getUser().getUsername() : null);
        return res;
    }
}
