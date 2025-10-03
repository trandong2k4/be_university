package com.university.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "baiviets")
public class BaiViet {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "tieu_de", nullable = false, length = 255)
    private String tieuDe;

    @Column(name = "noi_dung", nullable = false, columnDefinition = "text")
    private String noiDung;

    @Column(name = "loai_bai_viet", length = 50)
    private String loaiBaiViet;

    @Column(name = "ngay_dang")
    private LocalDate ngayDang = LocalDate.now();

    @Column(name = "tac_gia", length = 100)
    private String tacGia;

    @Column(name = "trang_thai", length = 20)
    private String trangThai = "CONG_KHAI";

    @Column(name = "hinh_anh_url", length = 255)
    private String hinhAnhUrl;

    @Column(name = "file_dinh_kem_url", length = 255)
    private String fileDinhKemUrl;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public BaiViet() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(String loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }

    public LocalDate getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDate ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnhUrl() {
        return hinhAnhUrl;
    }

    public void setHinhAnhUrl(String hinhAnhUrl) {
        this.hinhAnhUrl = hinhAnhUrl;
    }

    public String getFileDinhKemUrl() {
        return fileDinhKemUrl;
    }

    public void setFileDinhKemUrl(String fileDinhKemUrl) {
        this.fileDinhKemUrl = fileDinhKemUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
