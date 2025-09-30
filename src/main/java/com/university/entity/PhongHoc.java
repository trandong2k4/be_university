package com.university.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "phonghocs")
public class PhongHoc {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_phong_hoc", unique = true, nullable = false, length = 5)
    private String maPhongHoc;

    @Column(name = "ten_phong", length = 50)
    private String tenPhong;

    @Column(name = "toa_nha", length = 50)
    private String toaNha;

    @Column(name = "tang")
    private Integer tang;

    @Column(name = "suc_chua")
    private Integer sucChua;

    @OneToMany(mappedBy = "phongHoc")
    private Set<LichHoc> lichHocs;

    public PhongHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public String getMaPhongHoc() {
        return maPhongHoc;
    }

    public void setMaPhongHoc(String maPhongHoc) {
        this.maPhongHoc = maPhongHoc;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getToaNha() {
        return toaNha;
    }

    public void setToaNha(String toaNha) {
        this.toaNha = toaNha;
    }

    public Integer getTang() {
        return tang;
    }

    public void setTang(Integer tang) {
        this.tang = tang;
    }

    public Integer getSucChua() {
        return sucChua;
    }

    public void setSucChua(Integer sucChua) {
        this.sucChua = sucChua;
    }

    public Set<LichHoc> getLichHocs() {
        return lichHocs;
    }

    public void setLichHocs(Set<LichHoc> lichHocs) {
        this.lichHocs = lichHocs;
    }
}
