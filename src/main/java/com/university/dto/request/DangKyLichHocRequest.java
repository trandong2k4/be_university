package com.university.dto.request;

import java.util.UUID;

public class DangKyLichHocRequest {
    private UUID sinhVienId;
    private UUID lichHocId;

    public DangKyLichHocRequest() {
    }

    public UUID getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(UUID sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public UUID getLichHocId() {
        return lichHocId;
    }

    public void setLichHocId(UUID lichHocId) {
        this.lichHocId = lichHocId;
    }

}
