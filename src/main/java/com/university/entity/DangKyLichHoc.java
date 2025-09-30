package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "dangky_lichhoc")
public class DangKyLichHoc {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "lichhoc_id", nullable = false)
    private LichHoc lichHoc;

    @ManyToOne
    @JoinColumn(name = "sinhvien_id", nullable = false)
    private SinhVien sinhVien;

    public DangKyLichHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public LichHoc getLichHoc() {
        return lichHoc;
    }

    public void setLichHoc(LichHoc lichHoc) {
        this.lichHoc = lichHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
}
