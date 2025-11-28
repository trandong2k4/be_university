package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.LoaiBaiVietEnum;
import com.university.enums.TrangThaiBaiVietEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaiVietResponseDTO {
    private UUID id;
    private String tieuDe;
    private String noiDung;
    private LoaiBaiVietEnum loaiBaiViet;
    private LocalDate ngayDang;
    private String tacGia;
    private TrangThaiBaiVietEnum trangThai;
    private String hinhAnhUrl;
    private String fileDinhKemUrl;
    private String tenNguoiDang;
}