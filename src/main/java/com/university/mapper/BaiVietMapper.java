package com.university.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.BaiVietResponseDTO;
import com.university.dto.request.BaiVietRequestDTO;
import com.university.entity.BaiViet;
import com.university.entity.User;
import com.university.enums.BaiVietEnum;

@Component
public class BaiVietMapper {

    public BaiViet toEntity(BaiVietRequestDTO dto, User user) {
        return BaiViet.builder()
                .tieuDe(dto.getTieuDe())
                .noiDung(dto.getNoiDung())
                .loaiBaiViet(dto.getLoaiBaiViet())
                .ngayDang(LocalDate.now())
                .tacGia(dto.getTacGia())
                .trangThai(dto.getTrangThai() != null ? dto.getTrangThai() : BaiVietEnum.CONG_KHAI)
                .hinhAnhUrl(dto.getHinhAnhUrl())
                .fileDinhKemUrl(dto.getFileDinhKemUrl())
                .user(user)
                .build();
    }

    public BaiVietResponseDTO toResponseDTO(BaiViet baiViet) {
        return BaiVietResponseDTO.builder()
                .id(baiViet.getId())
                .tieuDe(baiViet.getTieuDe())
                .noiDung(baiViet.getNoiDung())
                .loaiBaiViet(baiViet.getLoaiBaiViet())
                .ngayDang(baiViet.getNgayDang())
                .tacGia(baiViet.getTacGia())
                .trangThai(baiViet.getTrangThai())
                .hinhAnhUrl(baiViet.getHinhAnhUrl())
                .fileDinhKemUrl(baiViet.getFileDinhKemUrl())
                .tenNguoiDang(baiViet.getUser().getUsername())
                .build();
    }
}