package com.university.dto.request;

import java.time.LocalTime;

public class GioHocRequest {
    private String maGioHoc;
    private String tenGioHoc;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;

    public GioHocRequest() {
    }

    public GioHocRequest(String maGioHoc, String tenGioHoc, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc) {
        this.maGioHoc = maGioHoc;
        this.tenGioHoc = tenGioHoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaGioHoc() {
        return maGioHoc;
    }

    public void setMaGioHoc(String maGioHoc) {
        this.maGioHoc = maGioHoc;
    }

    public String getTenGioHoc() {
        return tenGioHoc;
    }

    public void setTenGioHoc(String tenGioHoc) {
        this.tenGioHoc = tenGioHoc;
    }

    public LocalTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

}
