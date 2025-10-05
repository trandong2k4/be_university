package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.BuoiHocResponseDTO;
import com.university.dto.request.BuoiHocRequestDTO;
import com.university.entity.BuoiHoc;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;

@Component
public class BuoiHocMapper {

    public BuoiHoc toEntity(BuoiHocRequestDTO dto, GioHoc gioHoc, LichHoc lichHoc) {
        return BuoiHoc.builder()
                .ngayHoc(dto.getNgayHoc())
                .thuTrongTuan(dto.getThuTrongTuan())
                .gioHoc(gioHoc)
                .lichHoc(lichHoc)
                .ghiChu(dto.getGhiChu())
                .build();
    }

    public BuoiHocResponseDTO toResponseDTO(BuoiHoc buoiHoc) {
        return BuoiHocResponseDTO.builder()
                .id(buoiHoc.getId())
                .ngayHoc(buoiHoc.getNgayHoc())
                .thuTrongTuan(buoiHoc.getThuTrongTuan())
                .tenGioHoc(buoiHoc.getGioHoc().getTenGioHoc())
                .tenMonHoc(buoiHoc.getLichHoc().getMonHoc().getTenMonHoc())
                // .caHoc(buoiHoc.getGioHoc().getCaHoc())
                .ghiChu(buoiHoc.getGhiChu())
                .build();
    }
}
