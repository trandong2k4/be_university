package com.university.dto.reponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class KetQuaHocTapResponse {
    private UUID id;
    private String maSinhVien;
    private String tenSinhVien;
    private String tenMonHoc;
    private String tenKiHoc;
    private BigDecimal diem;
    private String danhGia;
    private String ghiChu;
    private LocalDate ngayCapNhat;

    public KetQuaHocTapResponse() {
    }

    public KetQuaHocTapResponse(UUID id, String maSinhVien, String tenSinhVien, String tenMonHoc, String tenKiHoc,
            BigDecimal diem, String danhGia, String ghiChu, LocalDate ngayCapNhat) {
        this.id = id;
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.tenMonHoc = tenMonHoc;
        this.tenKiHoc = tenKiHoc;
        this.diem = diem;
        this.danhGia = danhGia;
        this.ghiChu = ghiChu;
        this.ngayCapNhat = ngayCapNhat;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getTenKiHoc() {
        return tenKiHoc;
    }

    public void setTenKiHoc(String tenKiHoc) {
        this.tenKiHoc = tenKiHoc;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDate getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDate ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

}