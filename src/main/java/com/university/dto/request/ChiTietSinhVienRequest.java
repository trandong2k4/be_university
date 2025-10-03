package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.GioiTinh;

public class ChiTietSinhVienRequest {
    private String diaChi;
    private LocalDate ngaySinh;
    private GioiTinh gioiTinh;
    private String quocTich;
    private String cccd;
    private String sdtNguoiThan;
    private UUID sinhVienId;

    public ChiTietSinhVienRequest() {
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

    public UUID getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(UUID sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

}
