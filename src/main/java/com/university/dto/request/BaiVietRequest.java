package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class BaiVietRequest {
    private String tieuDe;
    private String noiDung;
    private String loaiBaiViet;
    private LocalDate ngayDang;
    private String tacGia;
    private String trangThai;
    private String hinhAnhUrl;
    private String fileDinhKemUrl;
    private UUID userId;

    public BaiVietRequest() {
    }

    public BaiVietRequest(String tieuDe, String noiDung, String loaiBaiViet, LocalDate ngayDang, String tacGia,
            String trangThai, String hinhAnhUrl, String fileDinhKemUrl, UUID userId) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.loaiBaiViet = loaiBaiViet;
        this.ngayDang = ngayDang;
        this.tacGia = tacGia;
        this.trangThai = trangThai;
        this.hinhAnhUrl = hinhAnhUrl;
        this.fileDinhKemUrl = fileDinhKemUrl;
        this.userId = userId;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

}