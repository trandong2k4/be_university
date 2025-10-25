package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.ThuEnum;

@Entity
@Table(name = "buoihocs", uniqueConstraints = @UniqueConstraint(columnNames = { "ngay_Hoc", "gio_hoc_id",
        "lich_hoc_id" }))
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BuoiHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDate ngayHoc;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ThuEnum thuTrongTuan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gio_hoc_id", nullable = false)
    private GioHoc gioHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lich_hoc_id", nullable = false)
    private LichHoc lichHoc;

    @Column(length = 255)
    private String ghiChu;
}