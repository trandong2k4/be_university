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
public class DangKyLichHocResponseDTO {
    private UUID id;
    private String maSinhVien;
    private String hoTen;
    private String tenMonHoc;
    private String caHoc;
    private String thu;
}
