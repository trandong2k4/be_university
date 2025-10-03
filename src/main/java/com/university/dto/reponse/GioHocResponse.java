package com.university.dto.reponse;

import java.time.LocalTime;
import java.util.UUID;

public class GioHocResponse {
    private UUID id;
    private String maGioHoc;
    private String tenGioHoc;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;

    public GioHocResponse() {
    }

    public GioHocResponse(UUID id, String maGioHoc, String tenGioHoc, LocalTime thoiGianBatDau,
            LocalTime thoiGianKetThuc) {
        this.id = id;
        this.maGioHoc = maGioHoc;
        this.tenGioHoc = tenGioHoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
