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
@Table(name = "hocphis", uniqueConstraints = @UniqueConstraint(columnNames = { "sinh_vien_id", "ki_hoc_id" }))
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
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ki_hoc_id")
    private KiHoc kiHoc;
}