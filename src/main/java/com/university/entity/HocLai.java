package com.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "hoclais")
public class HocLai {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "monhoc_id", nullable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "kihoc_id", nullable = false)
    private KiHoc kiHoc;

    @Column(name = "lan_hoc")
    private Integer lanHoc;

    @Column(name = "diem_cu", precision = 3, scale = 1)
    private BigDecimal diemCu;

    @Column(name = "ly_do", length = 255)
    private String lyDo;

    @Column(name = "trang_thai", length = 20)
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "lichhoc_id")
    private LichHoc lichHoc;

    public HocLai() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public KiHoc getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(KiHoc kiHoc) {
        this.kiHoc = kiHoc;
    }

    public Integer getLanHoc() {
        return lanHoc;
    }

    public void setLanHoc(Integer lanHoc) {
        this.lanHoc = lanHoc;
    }

    public BigDecimal getDiemCu() {
        return diemCu;
    }

    public void setDiemCu(BigDecimal diemCu) {
        this.diemCu = diemCu;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public LichHoc getLichHoc() {
        return lichHoc;
    }

    public void setLichHoc(LichHoc lichHoc) {
        this.lichHoc = lichHoc;
    }
}
