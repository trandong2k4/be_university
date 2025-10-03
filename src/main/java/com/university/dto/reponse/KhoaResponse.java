package com.university.dto.reponse;

import java.util.UUID;

public class KhoaResponse {
    private UUID id;
    private String maKhoa;
    private String tenKhoa;
    private String tenTruong; // trả về tên trường

    public KhoaResponse() {
    }

    public KhoaResponse(UUID id, String maKhoa, String tenKhoa, String tenTruong) {
        this.id = id;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.tenTruong = tenTruong;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

}
