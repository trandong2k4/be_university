package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "giohocs")
@Data
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
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;

    @OneToOne(mappedBy = "gioHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private LichHoc lichHoc;
}