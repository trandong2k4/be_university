package com.university.dto.request;

public class LoaiTinChiRequest {
    private String maLoaiTinChi;
    private String tenLoaiTinChi;

    public LoaiTinChiRequest() {
    }

    public LoaiTinChiRequest(String maLoaiTinChi, String tenLoaiTinChi) {
        this.maLoaiTinChi = maLoaiTinChi;
        this.tenLoaiTinChi = tenLoaiTinChi;
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

}