package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import com.university.enums.HocPhiEnum;

@Entity
@Table(name = "hocphis", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "sinhvien_id", "kihoc_id" })
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HocPhi {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    private SinhVien sinhVien;

    @ManyToOne
    private KiHoc kiHoc;

    private BigDecimal soTien;
    private BigDecimal giaTriTinChi;
    private LocalDate ngayTao;
    private LocalDate hanThanhToan;
    private LocalDate ngayThanhToan;

    @Enumerated(EnumType.STRING)
    private HocPhiEnum trangThai;

    private String ghiChu;
}