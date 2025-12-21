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
import com.university.enums.HocPhiEnum;

@Entity
@Table(name = "hocphis")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HocPhi {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private int soTinChi;

    private BigDecimal soTien;

    private LocalDate ngayTao;

    private LocalDate hanThanhToan;

    private LocalDate ngayThanhToan;

    @Enumerated(EnumType.STRING)
    private HocPhiEnum trangThai;

    private String ghiChu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sinh_vien_id", nullable = false)
    private SinhVien sinhVien;
}