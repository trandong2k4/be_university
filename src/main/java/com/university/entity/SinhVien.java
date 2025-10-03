package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "sinhviens")
public class SinhVien {

    @Id
    private UUID id;

    @Column(name = "ma_sinh_vien", unique = true, nullable = false, length = 10)
    private String maSinhVien;

    private String hoTen;

    @Column(unique = true, length = 50)
    private String email;

    @Column(unique = true, length = 10)
    private String soDienThoai;

    private LocalDate ngayNhapHoc;
    private LocalDate ngayTotNghiep;

    @ManyToOne
    @JoinColumn(name = "nganh_id", nullable = false)
    private Nganh nganh;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @OneToOne(mappedBy = "sinhVien", cascade = CascadeType.ALL)
    private ChiTietSinhVien chiTiet;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgayNhapHoc() {
        return ngayNhapHoc;
    }

    public void setNgayNhapHoc(LocalDate ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public LocalDate getNgayTotNghiep() {
        return ngayTotNghiep;
    }

    public void setNgayTotNghiep(LocalDate ngayTotNghiep) {
        this.ngayTotNghiep = ngayTotNghiep;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChiTietSinhVien getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(ChiTietSinhVien chiTiet) {
        this.chiTiet = chiTiet;
    }

    public SinhVien() {
    }

}