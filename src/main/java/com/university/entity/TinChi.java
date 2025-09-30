package com.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tinchi")
public class TinChi {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "so_tin_chi", nullable = false)
    private Integer soTinChi;

    @Column(name = "gia_tri_tin_chi", nullable = false, precision = 10, scale = 2)
    private BigDecimal giaTriTinChi;

    @Column(name = "ten_tin_chi", nullable = false, length = 50)
    private String tenTinChi;

    @ManyToOne
    @JoinColumn(name = "loaitinchi_id")
    private LoaiTinChi loaiTinChi;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHoc monHoc;

    public TinChi(LoaiTinChi loaiTinChi, MonHoc monHoc) {
        this.loaiTinChi = loaiTinChi;
        this.monHoc = monHoc;
    }

    public TinChi() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    public BigDecimal getGiaTriTinChi() {
        return giaTriTinChi;
    }

    public void setGiaTriTinChi(BigDecimal giaTriTinChi) {
        this.giaTriTinChi = giaTriTinChi;
    }

    public String getTenTinChi() {
        return tenTinChi;
    }

    public void setTenTinChi(String tenTinChi) {
        this.tenTinChi = tenTinChi;
    }

    public LoaiTinChi getLoaiTinChi() {
        return loaiTinChi;
    }

    public void setLoaiTinChi(LoaiTinChi loaiTinChi) {
        this.loaiTinChi = loaiTinChi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
}
