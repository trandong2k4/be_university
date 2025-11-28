package com.university.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.university.enums.TrangThaiLHP;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lophocphans")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LopHocPhan {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_lop_hoc_phan", nullable = false, unique = true, length = 50)
    private String maLopHocPhan;

    // ─── FK đến bảng giangvien ─────────────────────────────────────────
    @ManyToOne
    @JoinColumn(name = "giang_vien_id", nullable = false)
    private GiangVien giangVien;

    @Column
    private Integer soLuongToiDa;

    @Column
    private Integer soLuongHienTai;

    @Column
    private TrangThaiLHP trangThai;

    // ─── FK đến bảng monhoc ────────────────────────────────────────────
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_hoc_id", nullable = false)
    private MonHoc monHoc;

    // ─── FK đến bảng kihoc ─────────────────────────────────────────────
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ki_hoc_id", nullable = false)
    @JsonBackReference
    private KiHoc kiHoc;

    // ─── FK đến bảng monhoc ────────────────────────────────────────────
    @OneToMany(mappedBy = "lopHocPhan", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LichHoc> lichHocs;
}
