package com.university.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public class TinChiRequest {
    private String tenTinChi;
    private Integer soTinChi;
    private BigDecimal giaTriTinChi;
    private UUID loaiTinChiId;
    private UUID monHocId;

    public TinChiRequest() {
    }

    public TinChiRequest(String tenTinChi, Integer soTinChi, BigDecimal giaTriTinChi, UUID loaiTinChiId,
            UUID monHocId) {
        this.tenTinChi = tenTinChi;
        this.soTinChi = soTinChi;
        this.giaTriTinChi = giaTriTinChi;
        this.loaiTinChiId = loaiTinChiId;
        this.monHocId = monHocId;
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

    public UUID getLoaiTinChiId() {
        return loaiTinChiId;
    }

    public void setLoaiTinChiId(UUID loaiTinChiId) {
        this.loaiTinChiId = loaiTinChiId;
    }

    public UUID getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(UUID monHocId) {
        this.monHocId = monHocId;
    }

}
