package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "buoihocs")
public class BuoiHoc {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "thu_trong_tuan", length = 50)
    private String thuTrongTuan;

    @ManyToOne
    @JoinColumn(name = "giohoc_id")
    private GioHoc gioHoc;

    @ManyToOne
    @JoinColumn(name = "lichhoc_id")
    private LichHoc lichHoc;

    public BuoiHoc() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
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
