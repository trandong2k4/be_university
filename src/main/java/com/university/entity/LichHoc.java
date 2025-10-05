package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "lichhocs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LichHoc {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    @ManyToOne
    private PhongHoc phongHoc;

    @ManyToOne
    private KiHoc kiHoc;

    @ManyToOne
    private MonHoc monHoc;
}