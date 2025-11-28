package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.math.BigDecimal;

@Entity
@Table(name = "vitris")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViTri {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_vi_tri", unique = true, nullable = false, length = 5)
    private String maViTri;

    @Column(name = "ten_vi_tri", nullable = false, length = 50)
    private String tenViTri;

    @Column(name = "mo_ta", columnDefinition = "VARCHAR(255)")
    private String moTa;

    @Column(name = "muc_luong_co_ban", precision = 12, scale = 2)
    private BigDecimal mucLuongCoBan;

    // @OneToMany(mappedBy = "viTri")
    // private Set<NhanVien> nhanVien = new HashSet<>();

    // @OneToMany(mappedBy = "viTri")
    // private Set<GiangVien> giangVien = new HashSet<>();

}