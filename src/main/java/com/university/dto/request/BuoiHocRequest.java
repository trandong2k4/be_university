package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class BuoiHocRequest {
    private LocalDate ngayHoc;
    private String thuTrongTuan;
    private UUID gioHocId;
    private UUID lichHocId;

    public BuoiHocRequest() {
    }

    public BuoiHocRequest(LocalDate ngayHoc, String thuTrongTuan, UUID gioHocId, UUID lichHocId) {
        this.ngayHoc = ngayHoc;
        this.thuTrongTuan = thuTrongTuan;
        this.gioHocId = gioHocId;
        this.lichHocId = lichHocId;
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

    public UUID getGioHocId() {
        return gioHocId;
    }

    public void setGioHocId(UUID gioHocId) {
        this.gioHocId = gioHocId;
    }

    public UUID getLichHocId() {
        return lichHocId;
    }

    public void setLichHocId(UUID lichHocId) {
        this.lichHocId = lichHocId;
    }

}
