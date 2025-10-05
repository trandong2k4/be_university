package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "truongs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truong {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_truong", length = 10, unique = true, nullable = false)
    private String maTruong;

    @Column(name = "ten_truong", length = 100)
    private String tenTruong;

    @Column(name = "dia_chi", length = 255)
    private String diaChi;

    @Column(name = "so_dien_thoai", length = 20)
    private String soDienThoai;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String website;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "logo_url", length = 255)
    private String logoUrl;

    @Column(name = "ngay_thanh_lap")
    private LocalDate ngayThanhLap;

    @Column(name = "nguoi_dai_dien", length = 100)
    private String nguoiDaiDien;

    @OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
    private Set<Khoa> khoas = new HashSet<>();
}