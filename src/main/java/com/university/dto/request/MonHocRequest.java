package com.university.dto.request;

public class MonHocRequest {
    private String maMonHoc;
    private String tenMonHoc;
    private String moTa;
    private Integer tongSoTinChi;

    public MonHocRequest() {
    }

    public MonHocRequest(String maMonHoc, String tenMonHoc, String moTa, Integer tongSoTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.moTa = moTa;
        this.tongSoTinChi = tongSoTinChi;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getTongSoTinChi() {
        return tongSoTinChi;
    }

    public void setTongSoTinChi(Integer tongSoTinChi) {
        this.tongSoTinChi = tongSoTinChi;
    }

}
