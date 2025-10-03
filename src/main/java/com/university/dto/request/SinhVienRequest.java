package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class SinhVienRequest {
    private String maSinhVien;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private LocalDate ngayNhapHoc;
    private LocalDate ngayTotNghiep;
    private UUID nganhId;
    private UUID userId;

    public SinhVienRequest() {
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgayNhapHoc() {
        return ngayNhapHoc;
    }

    public void setNgayNhapHoc(LocalDate ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public LocalDate getNgayTotNghiep() {
        return ngayTotNghiep;
    }

    public void setNgayTotNghiep(LocalDate ngayTotNghiep) {
        this.ngayTotNghiep = ngayTotNghiep;
    }

    public UUID getNganhId() {
        return nganhId;
    }

    public void setNganhId(UUID nganhId) {
        this.nganhId = nganhId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

}
