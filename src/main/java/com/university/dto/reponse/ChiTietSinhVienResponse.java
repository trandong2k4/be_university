package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.GioiTinh;

public class ChiTietSinhVienResponse {
    private UUID id;
    private String diaChi;
    private LocalDate ngaySinh;
    private GioiTinh gioiTinh;
    private String quocTich;
    private String cccd;
    private String sdtNguoiThan;
    private String hoTenSinhVien;
    private UUID sinhvien_id;

    public ChiTietSinhVienResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdtNguoiThan() {
        return sdtNguoiThan;
    }

    public void setSdtNguoiThan(String sdtNguoiThan) {
        this.sdtNguoiThan = sdtNguoiThan;
    }

    public String getHoTenSinhVien() {
        return hoTenSinhVien;
    }

    public void setHoTenSinhVien(String hoTenSinhVien) {
        this.hoTenSinhVien = hoTenSinhVien;
    }

    public UUID getSinhvien_id() {
        return sinhvien_id;
    }

    public void setSinhvien_id(UUID sinhvien_id) {
        this.sinhvien_id = sinhvien_id;
    }

}
