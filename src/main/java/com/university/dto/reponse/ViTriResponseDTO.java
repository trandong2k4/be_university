package com.university.dto.reponse;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViTriResponseDTO {
    private UUID id;
    private String maViTri;
    private String tenViTri;
    private String moTa;
    private BigDecimal mucLuongCoBan;
}