package com.university.dto.reponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.HocPhiEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HocPhiResponseDTO {
    private UUID id;
    private String tenSinhVien;
    private String maSinhVien;
    private String tenKiHoc;
    private BigDecimal soTien;
    private BigDecimal giaTriTinChi;
    private LocalDate hanThanhToan;
    private LocalDate ngayThanhToan;
    private HocPhiEnum trangThai;
    private String ghiChu;
}