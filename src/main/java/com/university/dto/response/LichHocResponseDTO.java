package com.university.dto.response;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LichHocResponseDTO {
    private UUID id;
    private LocalDate ngayHoc;
    private String tenLop;
    private String tenGiangVien;
    private String tengioHoc;
    private String tenMonHoc;
    private String tenPhong;
    private int tang;
    private String toaNha;
    private String ghiChu;
}