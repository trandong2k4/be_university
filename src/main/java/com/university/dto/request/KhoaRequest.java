package com.university.dto.request;

import java.util.UUID;

public class KhoaRequest {
    private String maKhoa;
    private String tenKhoa;
    private UUID truongId; // chỉ truyền ID của trường
    public KhoaRequest() {
    }
    public KhoaRequest(String maKhoa, String tenKhoa, UUID truongId) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.truongId = truongId;
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
    public UUID getTruongId() {
        return truongId;
    }
    public void setTruongId(UUID truongId) {
        this.truongId = truongId;
    }
    
}