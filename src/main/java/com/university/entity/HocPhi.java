package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.university.enums.HocPhiEnum;

@Entity
@Table(name = "hocphis", uniqueConstraints = @UniqueConstraint(columnNames = { "sinh_vien_id", "ki_hoc_id" }))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HocPhi {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private int soTinChi;
    private BigDecimal giaTriTinChi;
    private LocalDate ngayTao;
    private BigDecimal soTien;
    private LocalDate hanThanhToan;
    private LocalDate ngayThanhToan;

    @Enumerated(EnumType.STRING)
    private HocPhiEnum trangThai;

    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinh_vien_id", nullable = false)
    @JsonBackReference
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ki_hoc_id")
    @JsonBackReference
    private KiHoc kiHoc;
}