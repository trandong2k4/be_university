package com.university.entity;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monhocs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MonHoc {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_mon_hoc", length = 10, unique = true, nullable = false)
    private String maMonHoc;

    @Column(name = "ten_mon_hoc", length = 50)
    private String tenMonHoc;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "tong_so_tin_chi")
    private int tongSoTinChi;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mon_hoc_id")
    private MonHoc monHocTienQuyet;
}