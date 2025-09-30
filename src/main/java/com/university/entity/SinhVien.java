package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "sinhviens")
public class SinhVien {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_sinh_vien", unique = true, nullable = false, length = 10)
    private String maSinhVien;

    @Column(name = "ho_ten", length = 50)
    private String hoTen;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "so_dien_thoai", length = 10, unique = true)
    private String soDienThoai;

    @Column(name = "ngay_nhap_hoc")
    private LocalDate ngayNhapHoc;

    @Column(name = "ngay_tot_nghiep")
    private LocalDate ngayTotNghiep;

    @ManyToOne
    @JoinColumn(name = "nganh_id", nullable = false)
    private NganhHoc nganhHoc;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
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

    public NganhHoc getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(NganhHoc nganhHoc) {
        this.nganhHoc = nganhHoc;
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

    @Override
    public String toString() {
        return "SinhVien [id=" + id + ", maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", email=" + email
                + ", soDienThoai=" + soDienThoai + ", ngayNhapHoc=" + ngayNhapHoc + ", ngayTotNghiep=" + ngayTotNghiep
                + ", nganhHoc=" + nganhHoc + ", user=" + user + ", chiTiet=" + chiTiet + "]";
    }

}