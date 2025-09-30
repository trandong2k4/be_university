package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "chitietsinhviens")
public class ChiTietSinhVien {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh", length = 10)
    private String gioiTinh;

    @Column(name = "quoc_tich", length = 50)
    private String quocTich = "Viet Nam";

    @Column(name = "cccd", length = 12, unique = true)
    private String cccd;

    @Column(name = "sdt_nguoi_than", length = 10)
    private String sdtNguoiThan;

    @OneToOne
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;

    public ChiTietSinhVien() {
    }

    // Getters & Setters...
}