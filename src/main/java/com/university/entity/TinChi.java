package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

import com.university.enums.LoaiTinChiEnum;

@Entity
@Table(name = "tinchi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TinChi {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "so_tin_chi", nullable = false)
    private int soTinChi;

    @Column(name = "gia_tri_tin_chi", nullable = false)
    private BigDecimal giaTriTinChi;

    private LoaiTinChiEnum loaiTinChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_hoc_id", nullable = false)
    private MonHoc monHoc;
}
