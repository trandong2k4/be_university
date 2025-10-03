package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "loaitinchi")
public class LoaiTinChi {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_loai_tin_chi", unique = true, nullable = false, length = 5)
    private String maLoaiTinChi;

    @Column(name = "ten_loai_tin_chi", nullable = false, length = 50)
    private String tenLoaiTinChi;

    @OneToMany(mappedBy = "loaiTinChi")
    private Set<TinChi> tinChis;

    public LoaiTinChi() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public String getMaLoaiTinChi() {
        return maLoaiTinChi;
    }

    public void setMaLoaiTinChi(String maLoaiTinChi) {
        this.maLoaiTinChi = maLoaiTinChi;
    }

    public String getTenLoaiTinChi() {
        return tenLoaiTinChi;
    }

    public void setTenLoaiTinChi(String tenLoaiTinChi) {
        this.tenLoaiTinChi = tenLoaiTinChi;
    }

    public Set<TinChi> getTinChis() {
        return tinChis;
    }

    public void setTinChis(Set<TinChi> tinChis) {
        this.tinChis = tinChis;
    }
}
