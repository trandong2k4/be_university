package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "giangviens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiangVien {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_giang_vien", length = 15)
    private String manGV;

    @Column(name = "ho_ten", length = 50)
    private String hoTen;

    @Column(name = "so_dien_thoai", length = 10, unique = true)
    private String soDienThoai;

    @Column(name = "ngay_vao_lam")
    private LocalDate ngayVaoLam;

    @Column(name = "ngay_nghi_viec")
    private LocalDate ngayNghiViec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vitri_id")
    private ViTri viTri;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

}