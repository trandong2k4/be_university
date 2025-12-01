package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.MonHocResponseDTO;
import com.university.dto.request.MonHocRequestDTO;
import com.university.entity.MonHoc;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MonHocMapper {

    public MonHoc toEntity(MonHocRequestDTO dto) {
        return MonHoc.builder()
                .maMonHoc(dto.getMaMonHoc())
                .tenMonHoc(dto.getTenMonHoc())
                .moTa(dto.getMoTa())
                .tongSoTinChi(dto.getTongSoTinChi())
                .build();
    }

    public MonHocResponseDTO toResponseDTO(MonHoc monHoc) {
        return MonHocResponseDTO.builder()
                .id(monHoc.getId())
                .maMonHoc(monHoc.getMaMonHoc())
                .tenMonHoc(monHoc.getTenMonHoc())
                .moTa(monHoc.getMoTa())
                .tongSoTinChi(monHoc.getTongSoTinChi())
                .build();
    }
}