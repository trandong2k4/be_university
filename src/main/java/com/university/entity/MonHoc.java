package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "monhocs")
public class MonHoc {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_mon_hoc", unique = true, nullable = false, length = 5)
    private String maMonHoc;

    @Column(name = "ten_mon_hoc", length = 50)
    private String tenMonHoc;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "tong_so_tin_chi")
    private Integer tongSoTinChi;

    @OneToMany(mappedBy = "monHoc")
    private Set<TinChi> tinChis;

    @OneToMany(mappedBy = "monHoc")
    private Set<MonHocTienQuyet> monHocTienQuyets;

    @OneToMany(mappedBy = "monHoc")
    private Set<HocLai> hocLais;

    public MonHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getTongSoTinChi() {
        return tongSoTinChi;
    }

    public void setTongSoTinChi(Integer tongSoTinChi) {
        this.tongSoTinChi = tongSoTinChi;
    }

    public Set<TinChi> getTinChis() {
        return tinChis;
    }

    public void setTinChis(Set<TinChi> tinChis) {
        this.tinChis = tinChis;
    }

    public Set<MonHocTienQuyet> getMonHocTienQuyets() {
        return monHocTienQuyets;
    }

    public void setMonHocTienQuyets(Set<MonHocTienQuyet> monHocTienQuyets) {
        this.monHocTienQuyets = monHocTienQuyets;
    }

    public Set<HocLai> getHocLais() {
        return hocLais;
    }

    public void setHocLais(Set<HocLai> hocLais) {
        this.hocLais = hocLais;
    }
}
