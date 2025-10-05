package com.university.dto.reponse;

import java.math.BigDecimal;
import java.util.UUID;

import com.university.enums.HocLaiEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HocLaiResponseDTO {
    private UUID id;
    private String tenSinhVien;
    private String maSinhVien;
    private String tenMonHoc;
    private String tenKiHoc;
    private int lanHoc;
    private BigDecimal diemCu;
    private HocLaiEnum trangThai;
    private String lyDo;
}
