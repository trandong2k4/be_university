package com.university.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class KetQuaHocTapRequest {
    private UUID sinhVienId;
    private UUID monHocId;
    private UUID kiHocId;
    private BigDecimal diem;
    private String danhGia;
    private String ghiChu;
    private LocalDate ngayCapNhat;

    public KetQuaHocTapRequest() {
    }

    public KetQuaHocTapRequest(UUID sinhVienId, UUID monHocId, UUID kiHocId, BigDecimal diem, String danhGia,
            String ghiChu, LocalDate ngayCapNhat) {
        this.sinhVienId = sinhVienId;
        this.monHocId = monHocId;
        this.kiHocId = kiHocId;
        this.diem = diem;
        this.danhGia = danhGia;
        this.ghiChu = ghiChu;
        this.ngayCapNhat = ngayCapNhat;
    }

    public UUID getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(UUID sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public UUID getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(UUID monHocId) {
        this.monHocId = monHocId;
    }

    public UUID getKiHocId() {
        return kiHocId;
    }

    public void setKiHocId(UUID kiHocId) {
        this.kiHocId = kiHocId;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDate getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDate ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

}
