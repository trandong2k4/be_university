package com.university.dto.request;

import java.util.UUID;

public class NganhRequest {
    private String maNganh;
    private String tenNganh;
    private UUID khoaId; // chỉ truyền ID của khoa

    public NganhRequest() {
    }

    public NganhRequest(String maNganh, String tenNganh, UUID khoaId) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.khoaId = khoaId;
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

    public UUID getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(UUID khoaId) {
        this.khoaId = khoaId;
    }

}
