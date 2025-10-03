package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;

import com.university.enums.GioiTinh;

import java.time.LocalDate;

@Entity
@Table(name = "chitietsinhviens")
public class ChiTietSinhVien {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh", length = 10)
    private GioiTinh gioiTinh;

    @Column(name = "quoc_tich", length = 50)
    private String quocTich = "Viet Nam";

    @Column(name = "cccd", length = 12, unique = true)
    private String cccd;

    @Column(name = "sdt_nguoi_than", length = 10)
    private String sdtNguoiThan;

    @OneToOne
    @JoinTable(name = "sinhviens")
    private SinhVien sinhVien;

    public ChiTietSinhVien() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdtNguoiThan() {
        return sdtNguoiThan;
    }

    public void setSdtNguoiThan(String sdtNguoiThan) {
        this.sdtNguoiThan = sdtNguoiThan;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

}