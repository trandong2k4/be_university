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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ketquahoctaps", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "sinhvien_id", "monhoc_id", "kihoc_id" })
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KetQuaHocTap {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "diem", precision = 3, scale = 1)
    private BigDecimal diem;

    @Column(name = "danh_gia", length = 50)
    private String danhGia;

    @Column(name = "ghi_chu", columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monhoc_id", nullable = false)
    private MonHoc monHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kihoc_id", nullable = false)
    private KiHoc kiHoc;
}