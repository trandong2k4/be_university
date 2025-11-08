package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "vitris")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViTri {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_vi_tri", unique = true, nullable = false, length = 5)
    private String maViTri;

    @Column(name = "ten_vi_tri", nullable = false, length = 50)
    private String tenViTri;

    @Column(name = "mo_ta", length = 255, columnDefinition = "nvarchar")
    private String moTa;

    @Column(name = "muc_luong_co_ban", precision = 12, scale = 2)
    private BigDecimal mucLuongCoBan;

    @OneToMany(mappedBy = "viTri")
    @JsonIgnore
    private Set<NhanVien> nhanViens;

}