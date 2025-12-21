package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "dangky_tinchi")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DangKyTinChi {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "lop_hoc_phan_id", nullable = false)
    private LopHocPhan lopHocPhan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sinh_vien_id", nullable = false)
    private SinhVien sinhVien;
}
