package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.enums.ThuEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuoiHocResponseDTO {
    private UUID id;
    private LocalDate ngayHoc;
    private ThuEnum thuTrongTuan;
    private String tenGioHoc;
    private String tenMonHoc;
    // private String caHoc;
    private String ghiChu;
}