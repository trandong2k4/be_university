package com.university.dto.reponse;

import java.math.BigDecimal;
import java.util.UUID;

public class ViTriResponse {
    private UUID id;
    private String maViTri;
    private String tenViTri;
    private String moTa;
    private BigDecimal mucLuongCoBan;
    private int soLuongNhanVien; // tổng số nhân viên ở vị trí này

    public ViTriResponse() {
    }

    public ViTriResponse(UUID id, String maViTri, String tenViTri, String moTa, BigDecimal mucLuongCoBan,
            int soLuongNhanVien) {
        this.id = id;
        this.maViTri = maViTri;
        this.tenViTri = tenViTri;
        this.moTa = moTa;
        this.mucLuongCoBan = mucLuongCoBan;
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

}
