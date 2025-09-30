package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "nganhhocs")
public class NganhHoc {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_nganh", unique = true, nullable = false, length = 5)
    private String maNganh;

    @Column(name = "ten_nganh", length = 100)
    private String tenNganh;

    @ManyToOne
    @JoinColumn(name = "khoa_id", nullable = false)
    private Khoa khoa;

    @OneToMany(mappedBy = "nganhHoc")
    private Set<SinhVien> sinhViens;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public Set<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public void setSinhViens(Set<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    public NganhHoc() {
    }

    @Override
    public String toString() {
        return "NganhHoc [id=" + id + ", maNganh=" + maNganh + ", tenNganh=" + tenNganh + ", khoa=" + khoa
                + ", sinhViens=" + sinhViens + "]";
    }
}