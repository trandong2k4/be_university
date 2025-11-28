package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.LichHocResponseDTO;
import com.university.dto.request.LichHocRequestDTO;
import com.university.entity.GioHoc;
import com.university.entity.LichHoc;

@Component
public class LichHocMapper {

    public LichHoc toEntity(LichHocRequestDTO dto, GioHoc gioHoc) {
        return LichHoc.builder()
                .ngayHoc(dto.getNgayHoc())
                // .thuTrongTuan(dto.getThuTrongTuan())
                .gioHoc(gioHoc)
                .ghiChu(dto.getGhiChu())
                .build();
    }

    public LichHocResponseDTO toResponseDTO(LichHoc lichHoc) {
        return LichHocResponseDTO.builder()
                .id(lichHoc.getId())
                .ngayHoc(lichHoc.getNgayHoc())
                // .thuTrongTuan(buoiHoc.getThuTrongTuan())
                .tenGioHoc(lichHoc.getGioHoc().getTenGioHoc())
                .ghiChu(lichHoc.getGhiChu())
                .build();
    }
}