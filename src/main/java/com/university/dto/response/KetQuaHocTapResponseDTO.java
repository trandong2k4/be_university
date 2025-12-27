package com.university.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
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
public class KetQuaHocTapResponseDTO {
    private UUID id;
    private String tenSinhVien;
    private String tenMonHoc;
    private String tenKiHoc;
    private BigDecimal chuyenCan;
    private BigDecimal thuongKi;
    private BigDecimal giuaKi;
    private BigDecimal cuoiKi;
    private String danhGia;
    private String ghiChu;
    private LocalDate ngayCapNhat;

}