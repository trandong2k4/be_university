package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "lichhocs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LichHoc {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private LocalDate ngayHoc;

    @Column(length = 255)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lop_hoc_phan_id")
    private LopHocPhan lopHocPhan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gio_hoc_id", nullable = false)
    private GioHoc gioHoc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phong_hoc_id")
    private PhongHoc phongHoc;

}