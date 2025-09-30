package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;
import java.time.LocalDate;

@Entity
@Table(name = "truongs")
public class Truong {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_truong", unique = true, nullable = false, length = 5)
    private String maTruong;

    @Column(name = "ten_truong", length = 100)
    private String tenTruong;

    @Column(name = "dia_chi", length = 255)
    private String diaChi;

    @Column(name = "so_dien_thoai", length = 20)
    private String soDienThoai;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "website", length = 100)
    private String website;

    @Column(name = "mo_ta", columnDefinition = "text")
    private String moTa;

    @Column(name = "logo_url", length = 255)
    private String logoUrl;

    @Column(name = "ngay_thanh_lap")
    private LocalDate ngayThanhLap;

    @Column(name = "nguoi_dai_dien", length = 100)
    private String nguoiDaiDien;

    @OneToMany(mappedBy = "truong")
    private Set<Khoa> khoas;

    public Truong() {
    }

    @Override
    public String toString() {
        return "Truong [id=" + id + ", maTruong=" + maTruong + ", tenTruong=" + tenTruong + ", diaChi=" + diaChi
                + ", soDienThoai=" + soDienThoai + ", email=" + email + ", website=" + website + ", moTa=" + moTa
                + ", logoUrl=" + logoUrl + ", ngayThanhLap=" + ngayThanhLap + ", nguoiDaiDien=" + nguoiDaiDien
                + ", khoas=" + khoas + "]";
    }

    // Getters & Setters...

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public LocalDate getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(LocalDate ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getNguoiDaiDien() {
        return nguoiDaiDien;
    }

    public void setNguoiDaiDien(String nguoiDaiDien) {
        this.nguoiDaiDien = nguoiDaiDien;
    }

    public Set<Khoa> getKhoas() {
        return khoas;
    }

    public void setKhoas(Set<Khoa> khoas) {
        this.khoas = khoas;
    }

}