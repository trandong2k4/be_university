package com.university.dto.reponse;

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
    private String maSinhVien;
    private String tenMonHoc;
    private String tenKiHoc;
    private BigDecimal diem;
    private String danhGia;
    private String ghiChu;
    private LocalDate ngayCapNhat;
}