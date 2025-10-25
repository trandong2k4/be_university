package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.BaiVietEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaiVietResponseDTO {
    private UUID id;
    private String tieuDe;
    private String noiDung;
    private String loaiBaiViet;
    private LocalDate ngayDang;
    private String tacGia;
    private BaiVietEnum trangThai;
    private String hinhAnhUrl;  
    private String fileDinhKemUrl;
    private String tenNguoiDang;
}