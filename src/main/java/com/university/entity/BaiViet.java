package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;
import com.university.enums.LoaiBaiVietEnum;
import com.university.enums.TrangThaiBaiVietEnum;

@Entity
@Table(name = "baiviets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaiViet {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "tieu_de", length = 255, nullable = false)
    private String tieuDe;

    @Column(name = "noi_dung", columnDefinition = "TEXT", nullable = false)
    private String noiDung;

    @Enumerated(EnumType.STRING)
    @Column(name = "loai_bai_viet")
    private LoaiBaiVietEnum loaiBaiViet;

    @Column(name = "ngay_dang")
    public LocalDate ngayDang;

    @Column(name = "tac_gia", length = 100)
    private String tacGia;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai")
    public TrangThaiBaiVietEnum trangThai;

    @Column(name = "hinh_anh_url", length = 255)
    private String hinhAnhUrl;

    @Column(name = "file_dinh_kem_url", length = 255)
    private String fileDinhKemUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}