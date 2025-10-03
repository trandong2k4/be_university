package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.SinhVienResponse;
import com.university.dto.request.SinhVienRequest;
import com.university.entity.Nganh;
import com.university.entity.SinhVien;
import com.university.entity.User;

@Component
public class SinhVienMapper {

    public SinhVien toEntity(SinhVienRequest dto, Nganh nganh, User user) {
        SinhVien sv = new SinhVien();
        sv.setMaSinhVien(dto.getMaSinhVien());
        sv.setHoTen(dto.getHoTen());
        sv.setEmail(dto.getEmail());
        sv.setSoDienThoai(dto.getSoDienThoai());
        sv.setNgayNhapHoc(dto.getNgayNhapHoc());
        sv.setNgayTotNghiep(dto.getNgayTotNghiep());
        sv.setNganh(nganh);
        sv.setUser(user);
        return sv;
    }

    public SinhVienResponse toResponse(SinhVien sv) {
        SinhVienResponse res = new SinhVienResponse();
        res.setId(sv.getId());
        res.setMaSinhVien(sv.getMaSinhVien());
        res.setHoTen(sv.getHoTen());
        res.setEmail(sv.getEmail());
        res.setSoDienThoai(sv.getSoDienThoai());
        res.setNgayNhapHoc(sv.getNgayNhapHoc());
        res.setNgayTotNghiep(sv.getNgayTotNghiep());
        res.setNganhId(sv.getNganh().getId());
        res.setTenNganh(sv.getNganh().getTenNganh());
        res.setTenKhoa(sv.getNganh().getKhoa().getTenKhoa());
        res.setTenTruong(sv.getNganh().getKhoa().getTruong().getTenTruong());
        return res;
    }
}