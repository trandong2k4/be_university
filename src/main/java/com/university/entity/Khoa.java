package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "khoas")
public class Khoa {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_khoa", unique = true, nullable = false, length = 5)
    private String maKhoa;

    @Column(name = "ten_khoa", length = 100)
    private String tenKhoa;

    @ManyToOne
    @JoinColumn(name = "truong_id", nullable = false)
    private Truong truong;

    @OneToMany(mappedBy = "khoa")
    private Set<NganhHoc> nganhHocs;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public Truong getTruong() {
        return truong;
    }

    public void setTruong(Truong truong) {
        this.truong = truong;
    }

    public Set<NganhHoc> getNganhHocs() {
        return nganhHocs;
    }

    public void setNganhHocs(Set<NganhHoc> nganhHocs) {
        this.nganhHocs = nganhHocs;
    }

    public Khoa() {
    }

    @Override
    public String toString() {
        return "Khoa [id=" + id + ", maKhoa=" + maKhoa + ", tenKhoa=" + tenKhoa + ", truong=" + truong + ", nganhHocs="
                + nganhHocs + "]";
    }
}