package com.university.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.KetQuaHocTapResponse;
import com.university.dto.request.KetQuaHocTapRequest;
import com.university.entity.KetQuaHocTap;
import com.university.entity.KiHoc;
import com.university.entity.MonHoc;
import com.university.entity.SinhVien;

@Component
public class KetQuaHocTapMapper {

    public KetQuaHocTap toEntity(KetQuaHocTapRequest dto, SinhVien sinhVien, MonHoc monHoc, KiHoc kiHoc) {
        KetQuaHocTap entity = new KetQuaHocTap();
        entity.setSinhVien(sinhVien);
        entity.setMonHoc(monHoc);
        entity.setKiHoc(kiHoc);
        entity.setDiem(dto.getDiem());
        entity.setDanhGia(dto.getDanhGia());
        entity.setGhiChu(dto.getGhiChu());
        entity.setNgayCapNhat(dto.getNgayCapNhat() != null ? dto.getNgayCapNhat() : LocalDate.now());
        return entity;
    }

    public void updateEntity(KetQuaHocTap entity, KetQuaHocTapRequest dto, SinhVien sinhVien, MonHoc monHoc,
            KiHoc kiHoc) {
        entity.setSinhVien(sinhVien);
        entity.setMonHoc(monHoc);
        entity.setKiHoc(kiHoc);
        entity.setDiem(dto.getDiem());
        entity.setDanhGia(dto.getDanhGia());
        entity.setGhiChu(dto.getGhiChu());
        entity.setNgayCapNhat(dto.getNgayCapNhat());
    }

    public KetQuaHocTapResponse toResponse(KetQuaHocTap entity) {
        KetQuaHocTapResponse response = new KetQuaHocTapResponse();
        response.setId(entity.getId());
        response.setMaSinhVien(entity.getSinhVien().getMaSinhVien());
        response.setTenSinhVien(entity.getSinhVien().getHoTen());
        response.setTenMonHoc(entity.getMonHoc().getTenMonHoc());
        response.setTenKiHoc(entity.getKiHoc().getTenKiHoc());
        response.setDiem(entity.getDiem());
        response.setDanhGia(entity.getDanhGia());
        response.setGhiChu(entity.getGhiChu());
        response.setNgayCapNhat(entity.getNgayCapNhat());
        return response;
    }
}
