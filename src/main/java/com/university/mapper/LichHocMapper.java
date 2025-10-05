package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.entity.KiHoc;
import com.university.entity.LichHoc;
import com.university.entity.MonHoc;
import com.university.entity.PhongHoc;

@Component
public class LichHocMapper {

    public LichHoc toEntity(LichHocRequestDTO dto, MonHoc monHoc, PhongHoc phongHoc, KiHoc kiHoc) {
        return LichHoc.builder()
                .monHoc(monHoc)
                .phongHoc(phongHoc)
                .kiHoc(kiHoc)
                .ngayBatDau(dto.getNgayBatDau())
                .ngayKetThuc(dto.getNgayKetThuc())
                .build();
    }

    public LichHocResponseDTO toResponseDTO(LichHoc lichHoc) {
        return LichHocResponseDTO.builder()
                .id(lichHoc.getId())
                .tenMonHoc(lichHoc.getMonHoc().getTenMonHoc())
                .tenPhongHoc(lichHoc.getPhongHoc().getTenPhong())
                .tenKiHoc(lichHoc.getKiHoc().getTenKiHoc())
                .ngayBatDau(lichHoc.getNgayBatDau())
                .ngayKetThuc(lichHoc.getNgayKetThuc())
                .build();
    }
}