package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(length = 15, unique = true, nullable = false)
    private String maKiHoc;

    @Column(length = 50)
    private String tenKiHoc;

    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    @OneToMany(mappedBy = "kiHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<HocPhi> hocPhi;

    @OneToMany(mappedBy = "kiHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LopHocPhan> lophocphans;
}