package com.university.dto.reponse;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonHocResponseDTO {
    private UUID id;
    private String maMonHoc;
    private String tenMonHoc;
    private String moTa;
    private int tongSoTinChi;
}