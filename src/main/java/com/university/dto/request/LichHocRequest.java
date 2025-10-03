package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public class LichHocRequest {
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private UUID phongHocId;
    private UUID kiHocId;
    private UUID monHocId;

    public LichHocRequest() {
    }

    public LichHocRequest(LocalDate ngayBatDau, LocalDate ngayKetThuc, UUID phongHocId, UUID kiHocId, UUID monHocId) {
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phongHocId = phongHocId;
        this.kiHocId = kiHocId;
        this.monHocId = monHocId;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public UUID getPhongHocId() {
        return phongHocId;
    }

    public void setPhongHocId(UUID phongHocId) {
        this.phongHocId = phongHocId;
    }

    public UUID getKiHocId() {
        return kiHocId;
    }

    public void setKiHocId(UUID kiHocId) {
        this.kiHocId = kiHocId;
    }

    public UUID getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(UUID monHocId) {
        this.monHocId = monHocId;
    }

}