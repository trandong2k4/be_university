package com.university.dto.reponse;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhoaResponseDTO {
    private UUID id;
    private String maKhoa;
    private String tenKhoa;
    private String tenTruong;
}