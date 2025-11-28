package com.university.dto.reponse;

import java.math.BigDecimal;
import java.util.UUID;
import com.university.enums.LoaiTinChiEnum;
import lombok.Data;

@Data
public class TinChiResponse {
    private UUID id;
    private String tenTinChi;
    private Integer soTinChi;
    private BigDecimal giaTriTinChi;
    private LoaiTinChiEnum tenLoaiTinChi;
    private String tenMonHoc;
}
