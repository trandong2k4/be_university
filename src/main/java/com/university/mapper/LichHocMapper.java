package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.LichHocResponse;
import com.university.dto.request.LichHocRequest;
import com.university.entity.KiHoc;
import com.university.entity.LichHoc;
import com.university.entity.MonHoc;
import com.university.entity.PhongHoc;

@Component
public class LichHocMapper {

    public LichHoc toEntity(LichHocRequest dto, PhongHoc phongHoc, KiHoc kiHoc, MonHoc monHoc) {
        LichHoc lich = new LichHoc();
        lich.setNgayBatDau(dto.getNgayBatDau());
        lich.setNgayKetThuc(dto.getNgayKetThuc());
        lich.setPhongHoc(phongHoc);
        lich.setKiHoc(kiHoc);
        lich.setMonHoc(monHoc);
        return lich;
    }

    public LichHocResponse toResponse(LichHoc lichHoc) {
        LichHocResponse res = new LichHocResponse();
        res.setId(lichHoc.getId());
        res.setNgayBatDau(lichHoc.getNgayBatDau());
        res.setNgayKetThuc(lichHoc.getNgayKetThuc());
        res.setTenPhong(lichHoc.getPhongHoc().getTenPhong());
        res.setTenKiHoc(lichHoc.getKiHoc().getTenKiHoc());
        res.setTenMonHoc(lichHoc.getMonHoc().getTenMonHoc());
        return res;
    }
}
