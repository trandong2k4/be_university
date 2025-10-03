package com.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ketquahoctaps")
public class KetQuaHocTap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "monhoc_id", nullable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "kihoc_id", nullable = false)
    private KiHoc kiHoc;

    @Column(precision = 3, scale = 1)
    private BigDecimal diem;

    @Column(name = "danh_gia", length = 50)
    private String danhGia;

    @Column(name = "ghi_chu", columnDefinition = "text")
    private String ghiChu;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat = LocalDate.now();

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

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public KiHoc getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(KiHoc kiHoc) {
        this.kiHoc = kiHoc;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDate getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDate ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}