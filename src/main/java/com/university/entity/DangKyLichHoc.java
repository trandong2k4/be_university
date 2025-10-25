package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "dangky_lichhoc", uniqueConstraints = @UniqueConstraint(columnNames = { "lich_hoc_id", "sinh_vien_id" }))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DangKyLichHoc {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lich_hoc_id", nullable = false)
    private LichHoc lichHoc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sinh_vien_id", nullable = false)
    private SinhVien sinhVien;
}
