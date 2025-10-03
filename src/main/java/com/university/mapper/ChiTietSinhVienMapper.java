package com.university.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.ChiTietSinhVienResponse;
import com.university.dto.request.ChiTietSinhVienRequest;
import com.university.entity.ChiTietSinhVien;
import com.university.entity.SinhVien;

@Component
public class ChiTietSinhVienMapper {

    public ChiTietSinhVien toEntity(ChiTietSinhVienRequest dto, SinhVien sinhVien) {
        ChiTietSinhVien ct = new ChiTietSinhVien();
        ct.setDiaChi(dto.getDiaChi());
        ct.setNgaySinh(dto.getNgaySinh());
        ct.setGioiTinh(dto.getGioiTinh());
        ct.setQuocTich(dto.getQuocTich());
        ct.setCccd(dto.getCccd());
        ct.setSdtNguoiThan(dto.getSdtNguoiThan());
        ct.setSinhVien(sinhVien);
        return ct;
    }

    public ChiTietSinhVienResponse toResponse(ChiTietSinhVien ct) {
        ChiTietSinhVienResponse res = new ChiTietSinhVienResponse();
        res.setId(ct.getId());
        res.setDiaChi(ct.getDiaChi());
        res.setNgaySinh(ct.getNgaySinh());
        res.setGioiTinh(ct.getGioiTinh());
        res.setQuocTich(ct.getQuocTich());
        res.setCccd(ct.getCccd());
        res.setSdtNguoiThan(ct.getSdtNguoiThan());
        res.setSinhvien_id(ct.getSinhVien().getId());
        res.setHoTenSinhVien(ct.getSinhVien().getHoTen());
        return res;
    }
}