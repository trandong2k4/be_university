package com.university.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.university.enums.LoaiTinChiEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinChiRequest {
    private String tenTinChi;
    private Integer soTinChi;
    private BigDecimal giaTriTinChi;
    private LoaiTinChiEnum loaiTinChiId;
    private UUID monHocId;

}
