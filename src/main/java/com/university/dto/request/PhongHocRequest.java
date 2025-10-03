package com.university.dto.request;

public class PhongHocRequest {
    private String maPhongHoc;
    private String tenPhong;
    private String toaNha;
    private Integer tang;
    private Integer sucChua;

    public PhongHocRequest() {
    }

    public PhongHocRequest(String maPhongHoc, String tenPhong, String toaNha, Integer tang, Integer sucChua) {
        this.maPhongHoc = maPhongHoc;
        this.tenPhong = tenPhong;
        this.toaNha = toaNha;
        this.tang = tang;
        this.sucChua = sucChua;
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

}
