package com.university.dto.reponse;

import java.math.BigDecimal;
import java.util.UUID;

public class TinChiResponse {
    private UUID id;
    private String tenTinChi;
    private Integer soTinChi;
    private BigDecimal giaTriTinChi;
    private String tenLoaiTinChi;
    private String tenMonHoc;

    public TinChiResponse() {
    }

    public TinChiResponse(UUID id, String tenTinChi, Integer soTinChi, BigDecimal giaTriTinChi, String tenLoaiTinChi,
            String tenMonHoc) {
        this.id = id;
        this.tenTinChi = tenTinChi;
        this.soTinChi = soTinChi;
        this.giaTriTinChi = giaTriTinChi;
        this.tenLoaiTinChi = tenLoaiTinChi;
        this.tenMonHoc = tenMonHoc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTenTinChi() {
        return tenTinChi;
    }

    public void setTenTinChi(String tenTinChi) {
        this.tenTinChi = tenTinChi;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    public BigDecimal getGiaTriTinChi() {
        return giaTriTinChi;
    }

    public void setGiaTriTinChi(BigDecimal giaTriTinChi) {
        this.giaTriTinChi = giaTriTinChi;
    }

    public String getTenLoaiTinChi() {
        return tenLoaiTinChi;
    }

    public void setTenLoaiTinChi(String tenLoaiTinChi) {
        this.tenLoaiTinChi = tenLoaiTinChi;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

}
