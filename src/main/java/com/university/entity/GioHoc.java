package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "giohocs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GioHoc {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_gio_hoc", length = 10, unique = true, nullable = false)
    private String maGioHoc;

    private String tenGioHoc;

    private Time thoiGianBatDau;

    private Time thoiGianKetThuc;

}