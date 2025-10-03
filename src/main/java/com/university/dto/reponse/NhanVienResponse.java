package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

public class NhanVienResponse {
    private UUID id;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private LocalDate ngayVaoLam;
    private LocalDate ngayNghiViec;
    private String tenViTri;
    private String username;

    public NhanVienResponse() {
    }

    public NhanVienResponse(UUID id, String hoTen, String email, String soDienThoai, LocalDate ngayVaoLam,
            LocalDate ngayNghiViec, String tenViTri, String username) {
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayVaoLam = ngayVaoLam;
        this.ngayNghiViec = ngayNghiViec;
        this.tenViTri = tenViTri;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}