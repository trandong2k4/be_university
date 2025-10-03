package com.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.TrangThaiHocPhi;

@Entity
@Table(name = "hocphis")
public class HocPhi {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "kihoc_id", nullable = false)
    private KiHoc kiHoc;

    @Column(name = "so_tien", nullable = false, precision = 12, scale = 2)
    private BigDecimal soTien;

    @Column(name = "gia_tri_tin_chi", precision = 10, scale = 2)
    private BigDecimal giaTriTinChi;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "han_thanh_toan")
    private LocalDate hanThanhToan;

    @Column(name = "ngay_thanh_toan")
    private LocalDate ngayThanhToan;

    @Enumerated(EnumType.STRING)
    private TrangThaiHocPhi trangThai;

    @Column(name = "ghi_chu", length = 255)
    private String ghiChu;

    public HocPhi() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public KiHoc getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(KiHoc kiHoc2) {
        this.kiHoc = kiHoc2;
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
