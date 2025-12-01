package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KiHocResponse {
    private UUID id;
    private String maKiHoc;
    private String tenKiHoc;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private int soLichHoc;
    private int soHocPhi;
    private int soHocLai;

}
