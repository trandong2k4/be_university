package com.university.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "kihocs")
public class KiHoc {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_ki_hoc", unique = true, nullable = false, length = 5)
    private String maKiHoc;

    @Column(name = "ten_ki_hoc", length = 50)
    private String tenKiHoc;

    @Column(name = "ngay_bat_dau")
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private LocalDate ngayKetThuc;

    @OneToMany(mappedBy = "kiHoc")
    private Set<LichHoc> lichHocs;

    @OneToMany(mappedBy = "kiHoc")
    private Set<HocPhi> hocPhis;

    @OneToMany(mappedBy = "kiHoc")
    private Set<HocLai> hocLais;

    public KiHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
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

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Set<LichHoc> getLichHocs() {
        return lichHocs;
    }

    public void setLichHocs(Set<LichHoc> lichHocs) {
        this.lichHocs = lichHocs;
    }

    public Set<HocPhi> getHocPhis() {
        return hocPhis;
    }

    public void setHocPhis(Set<HocPhi> hocPhis) {
        this.hocPhis = hocPhis;
    }

    public Set<HocLai> getHocLais() {
        return hocLais;
    }

    public void setHocLais(Set<HocLai> hocLais) {
        this.hocLais = hocLais;
    }
}
