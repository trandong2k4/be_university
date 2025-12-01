package com.university.dto.reponse;

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
public class PhongHocResponseDTO {
    private UUID id;
    private String maPhong;
    private String tenPhong;
    private String toaNha;
    private int tang;
    private int sucChua;
}