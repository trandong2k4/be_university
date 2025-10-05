package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "kihocs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KiHoc {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_ki_hoc", length = 10, unique = true, nullable = false)
    private String maKiHoc;

    @Column(name = "ten_ki_hoc", length = 50)
    private String tenKiHoc;

    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
}