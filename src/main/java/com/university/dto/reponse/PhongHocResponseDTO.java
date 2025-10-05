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
public class PhongHocResponseDTO {
    private UUID id;
    private String maPhong;
    private String tenPhong;
    private String toaNha;
    private int tang;
    private int sucChua;
}