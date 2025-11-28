package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.ThuEnum;

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
    private LocalDate ngayHoc;
    private ThuEnum thuTrongTuan;
    private String tenGioHoc;
    private String tenMonHoc;
    private String ghiChu;
}