package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "vitris")
public class ViTri {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_vi_tri", unique = true, nullable = false, length = 5)
    private String maViTri;

    @Column(name = "ten_vi_tri", nullable = false, length = 50)
    private String tenViTri;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "muc_luong_co_ban", precision = 12, scale = 2)
    private BigDecimal mucLuongCoBan;

    @OneToMany(mappedBy = "viTri")
    private Set<NhanVien> nhanViens;

    public ViTri() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getMucLuongCoBan() {
        return mucLuongCoBan;
    }

    public void setMucLuongCoBan(BigDecimal mucLuongCoBan) {
        this.mucLuongCoBan = mucLuongCoBan;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }
}
