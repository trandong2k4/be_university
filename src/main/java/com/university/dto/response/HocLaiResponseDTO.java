package com.university.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import com.university.enums.HocLaiEnum;
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
