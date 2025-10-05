package com.university.dto.reponse;

import java.time.LocalTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GioHocResponseDTO {
    private UUID id;
    private String maGioHoc;
    private String tenGioHoc;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;
}