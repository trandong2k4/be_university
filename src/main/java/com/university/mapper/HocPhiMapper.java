package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.HocPhiResponse;
import com.university.dto.request.HocPhiRequest;
import com.university.entity.HocPhi;
import com.university.entity.KiHoc;
import com.university.entity.SinhVien;

@Component
public class HocPhiMapper {

    public HocPhi toEntity(HocPhiRequest dto, SinhVien sinhVien, KiHoc kiHoc) {
        HocPhi entity = new HocPhi();
        entity.setSinhVien(sinhVien);
        entity.setKiHoc(kiHoc);
        entity.setSoTien(dto.getSoTien());
        entity.setGiaTriTinChi(dto.getGiaTriTinChi());
        entity.setNgayTao(dto.getNgayTao());
        entity.setHanThanhToan(dto.getHanThanhToan());
        entity.setNgayThanhToan(dto.getNgayThanhToan());
        entity.setTrangThai(dto.getTrangThai());
        entity.setGhiChu(dto.getGhiChu());
        return entity;
    }

    public void updateEntity(HocPhi entity, HocPhiRequest dto, SinhVien sinhVien, KiHoc kiHoc) {
        entity.setSinhVien(sinhVien);
        entity.setKiHoc(kiHoc);
        entity.setSoTien(dto.getSoTien());
        entity.setGiaTriTinChi(dto.getGiaTriTinChi());
        entity.setNgayTao(dto.getNgayTao());
        entity.setHanThanhToan(dto.getHanThanhToan());
        entity.setNgayThanhToan(dto.getNgayThanhToan());
        entity.setTrangThai(dto.getTrangThai());
        entity.setGhiChu(dto.getGhiChu());
    }

    public HocPhiResponse toResponse(HocPhi entity) {
        HocPhiResponse response = new HocPhiResponse();
        response.setId(entity.getId());
        response.setMaSinhVien(entity.getSinhVien().getMaSinhVien());
        response.setTenSinhVien(entity.getSinhVien().getHoTen());
        response.setMaKiHoc(entity.getKiHoc().getMaKiHoc());
        response.setTenKiHoc(entity.getKiHoc().getTenKiHoc());
        response.setSoTien(entity.getSoTien());
        response.setGiaTriTinChi(entity.getGiaTriTinChi());
        response.setNgayTao(entity.getNgayTao());
        response.setHanThanhToan(entity.getHanThanhToan());
        response.setNgayThanhToan(entity.getNgayThanhToan());
        response.setTrangThai(entity.getTrangThai());
        response.setGhiChu(entity.getGhiChu());
        return response;
    }
}
