package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "chuongtrinh_daotao")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChuongTrinhDaoTao {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nganh_id", nullable = false)
    private Nganh nganh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_hoc_id", nullable = false)
    private MonHoc monHoc;
}
