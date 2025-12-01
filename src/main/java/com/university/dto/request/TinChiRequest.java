package com.university.dto.request;

import java.math.BigDecimal;
import java.util.UUID;
import com.university.enums.LoaiTinChiEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TinChiRequest {
    private String tenTinChi;
    private Integer soTinChi;
    private BigDecimal giaTriTinChi;
    private LoaiTinChiEnum loaiTinChiId;
    private UUID monHocId;

}
