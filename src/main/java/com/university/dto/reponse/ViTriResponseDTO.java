package com.university.dto.reponse;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViTriResponseDTO {
    private UUID id;
    private String maViTri;
    private String tenViTri;
    private String moTa;
    private BigDecimal mucLuongCoBan;
}