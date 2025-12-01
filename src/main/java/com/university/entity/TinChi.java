package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;
import com.university.enums.LoaiTinChiEnum;

@Entity
@Table(name = "tinchi")
@Setter
@Getter
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

    @Column(name = "loai_tin_chi", nullable = false)
    private LoaiTinChiEnum loaiTinChi;

    @ManyToOne
    @JoinColumn(name = "mon_hoc_id", nullable = false)
    private MonHoc monHoc;
}
