package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.BuoiHocResponse;
import com.university.dto.request.BuoiHocRequest;
import com.university.entity.BuoiHoc;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;

@Component
public class BuoiHocMapper {

    public BuoiHoc toEntity(BuoiHocRequest dto, GioHoc gioHoc, LichHoc lichHoc) {
        BuoiHoc buoi = new BuoiHoc();
        buoi.setNgayHoc(dto.getNgayHoc());
        buoi.setThuTrongTuan(dto.getThuTrongTuan());
        buoi.setGioHoc(gioHoc);
        buoi.setLichHoc(lichHoc);
        return buoi;
    }

    public BuoiHocResponse toResponse(BuoiHoc buoiHoc) {
        BuoiHocResponse res = new BuoiHocResponse();
        res.setId(buoiHoc.getId());
        res.setNgayHoc(buoiHoc.getNgayHoc());
        res.setThuTrongTuan(buoiHoc.getThuTrongTuan());
        res.setTenGioHoc(buoiHoc.getGioHoc().getTenGioHoc());
        res.setThoiGianBatDau(buoiHoc.getGioHoc().getThoiGianBatDau().toString());
        res.setThoiGianKetThuc(buoiHoc.getGioHoc().getThoiGianKetThuc().toString());
        res.setTenMonHoc(buoiHoc.getLichHoc().getMonHoc().getTenMonHoc());
        res.setTenPhongHoc(buoiHoc.getLichHoc().getPhongHoc().getTenPhong());
        return res;
    }
}
