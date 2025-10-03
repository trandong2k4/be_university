package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

public class BuoiHocResponse {
    private UUID id;
    private LocalDate ngayHoc;
    private String thuTrongTuan;
    private String tenGioHoc;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String tenMonHoc;
    private String tenPhongHoc;

    public BuoiHocResponse() {
    }

    public BuoiHocResponse(UUID id, LocalDate ngayHoc, String thuTrongTuan, String tenGioHoc, String thoiGianBatDau,
            String thoiGianKetThuc, String tenMonHoc, String tenPhongHoc) {
        this.id = id;
        this.ngayHoc = ngayHoc;
        this.thuTrongTuan = thuTrongTuan;
        this.tenGioHoc = tenGioHoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.tenMonHoc = tenMonHoc;
        this.tenPhongHoc = tenPhongHoc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(LocalDate ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getThuTrongTuan() {
        return thuTrongTuan;
    }

    public void setThuTrongTuan(String thuTrongTuan) {
        this.thuTrongTuan = thuTrongTuan;
    }

    public String getTenGioHoc() {
        return tenGioHoc;
    }

    public void setTenGioHoc(String tenGioHoc) {
        this.tenGioHoc = tenGioHoc;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getTenPhongHoc() {
        return tenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        this.tenPhongHoc = tenPhongHoc;
    }

}
