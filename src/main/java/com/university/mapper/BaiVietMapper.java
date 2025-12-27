package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.request.BaiVietRequestDTO;
import com.university.dto.response.BaiVietResponseDTO;
import com.university.entity.BaiViet;
import com.university.entity.User;
import com.university.service.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BaiVietMapper {

    UserService userService;

    public BaiViet toEntity(BaiVietRequestDTO dto, User user) {
        return BaiViet.builder()
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