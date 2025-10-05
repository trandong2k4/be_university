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
public class LichHocResponseDTO {
    private UUID id;
    private String tenMonHoc;
    private String tenPhongHoc;
    private String tenKiHoc;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
}