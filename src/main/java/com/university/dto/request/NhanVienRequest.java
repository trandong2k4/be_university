package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class NhanVienRequest {
    private String hoTen;
    private String email;
    private String soDienThoai;
    private LocalDate ngayVaoLam;
    private LocalDate ngayNghiViec;
    private UUID viTriId;
    private UUID userId;

    public NhanVienRequest() {
    }

    public NhanVienRequest(String hoTen, String email, String soDienThoai, LocalDate ngayVaoLam, LocalDate ngayNghiViec,
            UUID viTriId, UUID userId) {
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayVaoLam = ngayVaoLam;
        this.ngayNghiViec = ngayNghiViec;
        this.viTriId = viTriId;
        this.userId = userId;
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

    public UUID getViTriId() {
        return viTriId;
    }

    public void setViTriId(UUID viTriId) {
        this.viTriId = viTriId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

}
