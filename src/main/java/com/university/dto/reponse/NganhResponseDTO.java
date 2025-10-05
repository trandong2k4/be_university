package com.university.dto.reponse;

import java.util.UUID;

import com.university.entity.Khoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NganhResponseDTO {
    private UUID id;
    private String maNganh;
    private String tenNganh;
    private Khoa khoa;
}