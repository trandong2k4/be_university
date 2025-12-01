package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.university.enums.GioiTinhEnum;
import java.time.LocalDate;

@Entity
@Table(name = "chitietsinhviens")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSinhVien {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Column
    private LocalDate ngaySinh;

    @Enumerated(EnumType.STRING)
    @Column
    private GioiTinhEnum gioiTinh;

    @Column(name = "quoc_tich", length = 30)
    private String quocTich;

    @Column(name = "cccd", length = 12, unique = true)
    private String cccd;

    @Column(name = "sdt_nguoi_than", length = 10)
    private String sdtNguoiThan;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sinh_vien_id", nullable = false)
    private SinhVien sinhVien;
}