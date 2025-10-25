package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@Entity
@Table(name = "nhanviens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

    @Id
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

}