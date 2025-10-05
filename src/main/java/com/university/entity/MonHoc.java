package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "monhocs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "ma_mon_hoc", length = 10, unique = true, nullable = false)
    private String maMonHoc;

    @Column(name = "ten_mon_hoc", length = 50)
    private String tenMonHoc;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "tong_so_tin_chi")
    private int tongSoTinChi;
}