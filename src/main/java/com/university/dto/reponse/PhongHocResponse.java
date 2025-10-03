package com.university.dto.reponse;

import java.util.UUID;

public class PhongHocResponse {
    private UUID id;
    private String maPhongHoc;
    private String tenPhong;
    private String toaNha;
    private Integer tang;
    private Integer sucChua;
    private int soLichHoc; // số lượng lịch học gắn với phòng

    public PhongHocResponse() {
    }

    public PhongHocResponse(UUID id, String maPhongHoc, String tenPhong, String toaNha, Integer tang, Integer sucChua,
            int soLichHoc) {
        this.id = id;
        this.maPhongHoc = maPhongHoc;
        this.tenPhong = tenPhong;
        this.toaNha = toaNha;
        this.tang = tang;
        this.sucChua = sucChua;
        this.soLichHoc = soLichHoc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaPhongHoc() {
        return maPhongHoc;
    }

    public void setMaPhongHoc(String maPhongHoc) {
        this.maPhongHoc = maPhongHoc;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getToaNha() {
        return toaNha;
    }

    public void setToaNha(String toaNha) {
        this.toaNha = toaNha;
    }

    public Integer getTang() {
        return tang;
    }

    public void setTang(Integer tang) {
        this.tang = tang;
    }

    public Integer getSucChua() {
        return sucChua;
    }

    public void setSucChua(Integer sucChua) {
        this.sucChua = sucChua;
    }

    public int getSoLichHoc() {
        return soLichHoc;
    }

    public void setSoLichHoc(int soLichHoc) {
        this.soLichHoc = soLichHoc;
    }

}
