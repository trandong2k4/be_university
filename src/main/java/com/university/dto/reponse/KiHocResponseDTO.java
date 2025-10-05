package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KiHocResponseDTO {
    private UUID id;
    private String tenKiHoc;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String ghiChu;
}
