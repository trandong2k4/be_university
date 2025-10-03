package com.university.dto.reponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.TrangThaiHocPhi;

public class HocPhiResponse {
    private UUID id;
    private String maSinhVien;
    private String tenSinhVien;
    private String maKiHoc;
    private String tenKiHoc;
    private BigDecimal soTien;
    private BigDecimal giaTriTinChi;
    private LocalDate ngayTao;
    private LocalDate hanThanhToan;
    private LocalDate ngayThanhToan;
    private TrangThaiHocPhi trangThai;
    private String ghiChu;

    public HocPhiResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
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

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }

    public BigDecimal getGiaTriTinChi() {
        return giaTriTinChi;
    }

    public void setGiaTriTinChi(BigDecimal giaTriTinChi) {
        this.giaTriTinChi = giaTriTinChi;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDate getHanThanhToan() {
        return hanThanhToan;
    }

    public void setHanThanhToan(LocalDate hanThanhToan) {
        this.hanThanhToan = hanThanhToan;
    }

    public LocalDate getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDate ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public TrangThaiHocPhi getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiHocPhi trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}