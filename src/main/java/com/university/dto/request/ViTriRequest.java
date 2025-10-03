package com.university.dto.request;

import java.math.BigDecimal;

public class ViTriRequest {
    private String maViTri;
    private String tenViTri;
    private String moTa;
    private BigDecimal mucLuongCoBan;

    public ViTriRequest() {
    }

    public ViTriRequest(String maViTri, String tenViTri, String moTa, BigDecimal mucLuongCoBan) {
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
        this.moTa = moTa;
        this.mucLuongCoBan = mucLuongCoBan;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getMucLuongCoBan() {
        return mucLuongCoBan;
    }

    public void setMucLuongCoBan(BigDecimal mucLuongCoBan) {
        this.mucLuongCoBan = mucLuongCoBan;
    }

}
