package com.university.dto.reponse;

import java.util.UUID;

public class NganhResponse {
    private UUID id;
    private String maNganh;
    private String tenNganh;
    private String tenKhoa; // trả về tên khoa

    public NganhResponse() {
    }

    public NganhResponse(UUID id, String maNganh, String tenNganh, String tenKhoa) {
        this.id = id;
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.tenKhoa = tenKhoa;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

}
