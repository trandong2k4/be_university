package com.university.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "lichhocs")
public class LichHoc {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ngay_bat_dau")
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private LocalDate ngayKetThuc;

    @ManyToOne
    @JoinColumn(name = "phonghoc_id")
    private PhongHoc phongHoc;

    @ManyToOne
    @JoinColumn(name = "kihoc_id")
    private KiHoc kiHoc;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "lichHoc")
    private Set<DangKyLichHoc> dangKyLichHocs;

    @OneToMany(mappedBy = "lichHoc")
    private Set<BuoiHoc> buoiHocs;

    public LichHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
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

    public PhongHoc getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(PhongHoc phongHoc) {
        this.phongHoc = phongHoc;
    }

    public KiHoc getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(KiHoc kiHoc) {
        this.kiHoc = kiHoc;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public Set<DangKyLichHoc> getDangKyLichHocs() {
        return dangKyLichHocs;
    }

    public void setDangKyLichHocs(Set<DangKyLichHoc> dangKyLichHocs) {
        this.dangKyLichHocs = dangKyLichHocs;
    }

    public Set<BuoiHoc> getBuoiHocs() {
        return buoiHocs;
    }

    public void setBuoiHocs(Set<BuoiHoc> buoiHocs) {
        this.buoiHocs = buoiHocs;
    }
}
