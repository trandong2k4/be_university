package com.university.dto.request;

import java.time.LocalDate;

public class TruongRequest {
    private String maTruong;
    private String tenTruong;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String website;
    private String moTa;
    private String logoUrl;
    private LocalDate ngayThanhLap;
    private String nguoiDaiDien;

    public TruongRequest() {
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public LocalDate getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(LocalDate ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getNguoiDaiDien() {
        return nguoiDaiDien;
    }

    public void setNguoiDaiDien(String nguoiDaiDien) {
        this.nguoiDaiDien = nguoiDaiDien;
    }

}
