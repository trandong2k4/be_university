package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@Entity
@Table(name = "sinhviens")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_sinh_vien", length = 10, unique = true, nullable = false)
    private String maSinhVien;

    @Column(name = "ho_ten", length = 50)
    private String hoTen;

    @Column(length = 50, unique = true)
    private String email;

    @Column(name = "so_dien_thoai", length = 10, unique = true)
    private String soDienThoai;

    @Column(name = "ngay_nhap_hoc")
    private LocalDate ngayNhapHoc;

    @Column(name = "ngay_tot_nghiep")
    private LocalDate ngayTotNghiep;

    @ManyToOne
    @JoinColumn(name = "nganh_id", nullable = false)
    private Nganh nganh;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "sinhVien", cascade = CascadeType.ALL)
    @JsonIgnore
    private ChiTietSinhVien chiTiet;
}