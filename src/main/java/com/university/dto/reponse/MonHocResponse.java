package com.university.dto.reponse;

import java.util.UUID;

public class MonHocResponse {
    private UUID id;
    private String maMonHoc;
    private String tenMonHoc;
    private String moTa;
    private Integer tongSoTinChi;
    private int soTinChiThucTe; // số lượng tín chỉ liên kết

    public MonHocResponse() {
    }

    public MonHocResponse(UUID id, String maMonHoc, String tenMonHoc, String moTa, Integer tongSoTinChi,
            int soTinChiThucTe) {
        this.id = id;
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.moTa = moTa;
        this.tongSoTinChi = tongSoTinChi;
        this.soTinChiThucTe = soTinChiThucTe;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getTongSoTinChi() {
        return tongSoTinChi;
    }

    public void setTongSoTinChi(Integer tongSoTinChi) {
        this.tongSoTinChi = tongSoTinChi;
    }

    public int getSoTinChiThucTe() {
        return soTinChiThucTe;
    }

    public void setSoTinChiThucTe(int soTinChiThucTe) {
        this.soTinChiThucTe = soTinChiThucTe;
    }

}