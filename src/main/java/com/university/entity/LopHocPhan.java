package com.university.entity;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.university.enums.TrangThaiLHP;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lophocphans")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LopHocPhan {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_lop_hoc_phan", nullable = false, unique = true, length = 50)
    private String maLopHocPhan;

    @Column
    private Integer soLuongToiDa;

    @Column
    private Integer soLuongHienTai;

    @Column
    private TrangThaiLHP trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mon_hoc_id", nullable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id", nullable = false)
    private GiangVien giangVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ki_hoc_id", nullable = false)
    private KiHoc kiHoc;

}
