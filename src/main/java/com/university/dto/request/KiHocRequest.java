package com.university.dto.request;

import java.time.LocalDate;

public class KiHocRequest {
    private String maKiHoc;
    private String tenKiHoc;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public KiHocRequest() {
    }

    public KiHocRequest(String maKiHoc, String tenKiHoc, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.maKiHoc = maKiHoc;
        this.tenKiHoc = tenKiHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaKiHoc() {
        return maKiHoc;
    }

    public void setMaKiHoc(String maKiHoc) {
        this.maKiHoc = maKiHoc;
    }

    public String getTenKiHoc() {
        return tenKiHoc;
    }

    public void setTenKiHoc(String tenKiHoc) {
        this.tenKiHoc = tenKiHoc;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

}
