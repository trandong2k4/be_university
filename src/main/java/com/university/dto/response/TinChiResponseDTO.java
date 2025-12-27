package com.university.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import com.university.enums.LoaiTinChiEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TinChiResponseDTO {
    private UUID id;
    private String tenTinChi;
    private Integer soTinChi;
    private BigDecimal giaTriTinChi;
    private LoaiTinChiEnum tenLoaiTinChi;
    private String tenMonHoc;
}
