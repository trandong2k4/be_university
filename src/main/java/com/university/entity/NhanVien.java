package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "nhanviens")
public class NhanVien {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ho_ten", length = 50)
    private String hoTen;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "so_dien_thoai", length = 10, unique = true)
    private String soDienThoai;

    @Column(name = "ngay_vao_lam")
    private LocalDate ngayVaoLam;

    @Column(name = "ngay_nghi_viec")
    private LocalDate ngayNghiViec;

    @ManyToOne
    @JoinColumn(name = "vitri_id")
    private ViTri viTri;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public NhanVien() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
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

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public LocalDate getNgayNghiViec() {
        return ngayNghiViec;
    }

    public void setNgayNghiViec(LocalDate ngayNghiViec) {
        this.ngayNghiViec = ngayNghiViec;
    }

    public ViTri getViTri() {
        return viTri;
    }

    public void setViTri(ViTri viTri) {
        this.viTri = viTri;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
