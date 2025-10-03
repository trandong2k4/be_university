package com.university.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.TrangThaiHocPhi;

public class HocPhiRequest {
    private UUID sinhVienId;
    private UUID kiHocId;
    private BigDecimal soTien;
    private BigDecimal giaTriTinChi;
    private LocalDate ngayTao;
    private LocalDate hanThanhToan;
    private LocalDate ngayThanhToan;
    private TrangThaiHocPhi trangThai;
    private String ghiChu;

    public HocPhiRequest() {
    }

    public HocPhiRequest(UUID sinhVienId, UUID kiHocId, BigDecimal soTien, BigDecimal giaTriTinChi, LocalDate ngayTao,
            LocalDate hanThanhToan, LocalDate ngayThanhToan, TrangThaiHocPhi trangThai, String ghiChu) {
        this.sinhVienId = sinhVienId;
        this.kiHocId = kiHocId;
        this.soTien = soTien;
        this.giaTriTinChi = giaTriTinChi;
        this.ngayTao = ngayTao;
        this.hanThanhToan = hanThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public UUID getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(UUID sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public UUID getKiHocId() {
        return kiHocId;
    }

    public void setKiHocId(UUID kiHocId) {
        this.kiHocId = kiHocId;
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
