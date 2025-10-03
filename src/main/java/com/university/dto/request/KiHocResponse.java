package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class KiHocResponse {
    private UUID id;
    private String maKiHoc;
    private String tenKiHoc;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private int soLichHoc;
    private int soHocPhi;
    private int soHocLai;

    public KiHocResponse() {
    }

    public KiHocResponse(UUID id, String maKiHoc, String tenKiHoc, LocalDate ngayBatDau, LocalDate ngayKetThuc,
            int soLichHoc, int soHocPhi, int soHocLai) {
        this.id = id;
        this.maKiHoc = maKiHoc;
        this.tenKiHoc = tenKiHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soLichHoc = soLichHoc;
        this.soHocPhi = soHocPhi;
        this.soHocLai = soHocLai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaKiHoc() {
        return maKiHoc;
    }

    public void setMaKiHoc(String maKiHoc) {
        this.maKiHoc = maKiHoc;
    }

    public String getTenKiHoc() {
        return tenKiHoc;
    }

    public void setTenKiHoc(String tenKiHoc) {
        this.tenKiHoc = tenKiHoc;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSoLichHoc() {
        return soLichHoc;
    }

    public void setSoLichHoc(int soLichHoc) {
        this.soLichHoc = soLichHoc;
    }

    public int getSoHocPhi() {
        return soHocPhi;
    }

    public void setSoHocPhi(int soHocPhi) {
        this.soHocPhi = soHocPhi;
    }

    public int getSoHocLai() {
        return soHocLai;
    }

    public void setSoHocLai(int soHocLai) {
        this.soHocLai = soHocLai;
    }

}
