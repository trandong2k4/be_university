package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import com.university.enums.GioiTinhEnum;

import java.time.LocalDate;

@Entity
@Table(name = "chitietsinhviens")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSinhVien {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Enumerated(EnumType.STRING)
    @Column(name = "gioi_tinh")
    private GioiTinhEnum gioiTinh;

    @Column(name = "quoc_tich", length = 50)
    private String quocTich = "Viet Nam";

    @Column(name = "cccd", length = 12, unique = true)
    private String cccd;

    @Column(name = "sdt_nguoi_than", length = 10)
    private String sdtNguoiThan;

    @OneToOne
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;
}