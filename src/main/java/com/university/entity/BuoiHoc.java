package com.university.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "buoihocs")
public class BuoiHoc {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "ngay_hoc", nullable = false)
    private LocalDate ngayHoc;

    @Column(name = "thu_trong_tuan", length = 20)
    private String thuTrongTuan; // Ví dụ: "Thứ Hai", "Thứ Ba"

    @ManyToOne
    @JoinColumn(name = "giohoc_id", nullable = false)
    private GioHoc gioHoc;

    @ManyToOne
    @JoinColumn(name = "lichhoc_id", nullable = false)
    private LichHoc lichHoc;

    // Constructors
    public BuoiHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public LocalDate getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(LocalDate ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getThuTrongTuan() {
        return thuTrongTuan;
    }

    public void setThuTrongTuan(String thuTrongTuan) {
        this.thuTrongTuan = thuTrongTuan;
    }

    public GioHoc getGioHoc() {
        return gioHoc;
    }

    public void setGioHoc(GioHoc gioHoc) {
        this.gioHoc = gioHoc;
    }

    public LichHoc getLichHoc() {
        return lichHoc;
    }

    public void setLichHoc(LichHoc lichHoc) {
        this.lichHoc = lichHoc;
    }
}
