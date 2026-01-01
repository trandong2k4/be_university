package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "sinhviens")
@Setter
@Getter
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

    @Column(name = "so_dien_thoai", length = 10, unique = true)
    private String soDienThoai;

    @Column(name = "ngay_nhap_hoc")
    private LocalDate ngayNhapHoc;

    @Column(name = "ngay_tot_nghiep")
    private LocalDate ngayTotNghiep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nganh_id", nullable = false)
    private Nganh nganh;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

}