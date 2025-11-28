package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.university.enums.ThuEnum;

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

    @Column(nullable = false)
    private LocalDate ngayHoc;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private ThuEnum thuTrongTuan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lop_hoc_phan_id", nullable = false)
    private LopHocPhan lopHocPhan;

    @Column(length = 255)
    private String ghiChu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gio_hoc_id", nullable = false)
    @JsonBackReference
    private GioHoc gioHoc;
}