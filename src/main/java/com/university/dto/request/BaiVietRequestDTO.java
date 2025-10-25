package com.university.dto.request;

import java.util.UUID;
import com.university.enums.BaiVietEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BaiVietRequestDTO {

    @NotBlank(message = "Tiêu đề không được để trống")
    private String tieuDe;

    @NotBlank(message = "Nội dung không được để trống")
    private String noiDung;

    private String loaiBaiViet;
    private String tacGia;
    private BaiVietEnum trangThai;
    private String hinhAnhUrl;
    private String fileDinhKemUrl;

    @NotNull(message = "User ID không được để trống")
    private UUID userId;
}