package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "kihocs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KiHoc {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 15, unique = true, nullable = false)
    private String maKiHoc;

    @Column(length = 50)
    private String tenKiHoc;

    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

}