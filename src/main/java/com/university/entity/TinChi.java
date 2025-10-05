package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

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

    @Column(name = "ten_tin_chi", length = 50, nullable = false)
    private String tenTinChi;

    @ManyToOne
    @JoinColumn(name = "loaitinchi_id")
    private LoaiTinChi loaiTinChi;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHoc monHoc;
}
