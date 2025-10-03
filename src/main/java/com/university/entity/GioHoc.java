package com.university.entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "giohocs")
public class GioHoc {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_gio_hoc", unique = true, nullable = false, length = 5)
    private String maGioHoc;

    @Column(name = "ten_gio_hoc", length = 50)
    private String tenGioHoc;

    @Column(name = "thoi_gian_bat_dau")
    private LocalTime thoiGianBatDau;

    @Column(name = "thoi_gian_ket_thuc")
    private LocalTime thoiGianKetThuc;

    @OneToMany(mappedBy = "gioHoc")
    private Set<BuoiHoc> buoiHocs;

    public GioHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public String getMaGioHoc() {
        return maGioHoc;
    }

    public void setMaGioHoc(String maGioHoc) {
        this.maGioHoc = maGioHoc;
    }

    public String getTenGioHoc() {
        return tenGioHoc;
    }

    public void setTenGioHoc(String tenGioHoc) {
        this.tenGioHoc = tenGioHoc;
    }

    public LocalTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Set<BuoiHoc> getBuoiHocs() {
        return buoiHocs;
    }

    public void setBuoiHocs(Set<BuoiHoc> buoiHocs) {
        this.buoiHocs = buoiHocs;
    }
}
