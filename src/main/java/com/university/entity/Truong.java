package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "truongs")
@Getter
@Setter
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

    @Column(name = "mo_ta", columnDefinition = "VARCHAR(255)")
    private String moTa;

    @Column(name = "logo_url", length = 255)
    private String logoUrl;

    @Column(name = "ngay_thanh_lap")
    private LocalDate ngayThanhLap;

    @Column(name = "nguoi_dai_dien", length = 100)
    private String nguoiDaiDien;
}