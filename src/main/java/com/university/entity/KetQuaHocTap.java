package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ketquahoctaps")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KetQuaHocTap {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(precision = 3, scale = 1)
    private BigDecimal chuyenCan;

    @Column(precision = 3, scale = 1)
    private BigDecimal thuongKi;

    @Column(precision = 3, scale = 1)
    private BigDecimal giuaKi;

    @Column(precision = 3, scale = 1)
    private BigDecimal cuoiKi;

    @Column(name = "danh_gia", length = 50)
    private String danhGia;

    @Column(name = "ghi_chu", columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dang_ky_tin_chi_id")
    private DangKyTinChi dangKyTinChi;

}