// package com.university.entity;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.NoArgsConstructor;
// import java.math.BigDecimal;
// import java.util.UUID;
// import com.university.enums.HocLaiEnum;

// @Entity
// @Table(name = "hoclais")
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class HocLai {

// @Id
// @GeneratedValue(generator = "UUID")
// private UUID id;

// @ManyToOne
// @JoinColumn(name = "sinhvien_id", nullable = false)
// private SinhVien sinhVien;

// @ManyToOne
// @JoinColumn(name = "monhoc_id", nullable = false)
// private MonHoc monHoc;

// @ManyToOne
// @JoinColumn(name = "kihoc_id", nullable = false)
// private KiHoc kiHoc;

// @Column(name = "lan_hoc")
// private int lanHoc;

// @Column(name = "diem_cu", precision = 3, scale = 1)
// private BigDecimal diemCu;

// @Column(name = "ly_do", length = 255)
// private String lyDo;

// @Enumerated(EnumType.STRING)
// @Column(name = "trang_thai")
// private HocLaiEnum trangThai;

// @ManyToOne
// @JoinColumn(name = "lichhoc_id")
// private LichHoc lichHoc;
// }