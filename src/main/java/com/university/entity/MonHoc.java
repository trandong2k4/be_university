package com.university.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monhocs")
@Data
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

    @OneToOne()
    @JoinColumn(name = "mon_hoc_id", nullable = false)
    private MonHoc monHocTienQuyet;

    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TinChi> tinChis;

    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
    private List<LopHocPhan> lophocphans;
}