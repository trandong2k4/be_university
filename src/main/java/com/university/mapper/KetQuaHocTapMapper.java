package com.university.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.KetQuaHocTapResponseDTO;
import com.university.dto.request.KetQuaHocTapRequestDTO;
import com.university.entity.KetQuaHocTap;
import com.university.entity.KiHoc;
import com.university.entity.MonHoc;
import com.university.entity.SinhVien;

@Component
public class KetQuaHocTapMapper {

    public KetQuaHocTap toEntity(KetQuaHocTapRequestDTO dto, SinhVien sv, MonHoc monHoc, KiHoc kiHoc) {
        return KetQuaHocTap.builder()
                .sinhVien(sv)
                .monHoc(monHoc)
                .kiHoc(kiHoc)
                .diem(dto.getDiem())
                .danhGia(dto.getDanhGia())
                .ghiChu(dto.getGhiChu())
                .ngayCapNhat(LocalDate.now())
                .build();
    }

    public KetQuaHocTapResponseDTO toResponseDTO(KetQuaHocTap kq) {
        return KetQuaHocTapResponseDTO.builder()
                .id(kq.getId())
                .tenSinhVien(kq.getSinhVien().getHoTen())
                .maSinhVien(kq.getSinhVien().getMaSinhVien())
                .tenMonHoc(kq.getMonHoc().getTenMonHoc())
                .tenKiHoc(kq.getKiHoc().getTenKiHoc())
                .diem(kq.getDiem())
                .danhGia(kq.getDanhGia())
                .ghiChu(kq.getGhiChu())
                .ngayCapNhat(kq.getNgayCapNhat())
                .build();
    }
}