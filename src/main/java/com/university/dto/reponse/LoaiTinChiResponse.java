package com.university.dto.reponse;

import java.util.UUID;

public class LoaiTinChiResponse {
    private UUID id;
    private String maLoaiTinChi;
    private String tenLoaiTinChi;
    private int soLuongTinChi; // tổng số tín chỉ thuộc loại này

    public LoaiTinChiResponse() {
    }

    public LoaiTinChiResponse(UUID id, String maLoaiTinChi, String tenLoaiTinChi, int soLuongTinChi) {
        this.id = id;
        this.maLoaiTinChi = maLoaiTinChi;
        this.tenLoaiTinChi = tenLoaiTinChi;
        this.soLuongTinChi = soLuongTinChi;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaLoaiTinChi() {
        return maLoaiTinChi;
    }

    public void setMaLoaiTinChi(String maLoaiTinChi) {
        this.maLoaiTinChi = maLoaiTinChi;
    }

    public String getTenLoaiTinChi() {
        return tenLoaiTinChi;
    }

    public void setTenLoaiTinChi(String tenLoaiTinChi) {
        this.tenLoaiTinChi = tenLoaiTinChi;
    }

    public int getSoLuongTinChi() {
        return soLuongTinChi;
    }

    public void setSoLuongTinChi(int soLuongTinChi) {
        this.soLuongTinChi = soLuongTinChi;
    }

}
