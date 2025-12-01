package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.PermissionResponseDTO;
import com.university.dto.request.PermissionRequestDTO;
import com.university.entity.Permission;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PermissionMapper {

    public Permission toEntity(PermissionRequestDTO dto) {
        return Permission.builder()
                .maPermission(dto.getTenPermission())
                .description(dto.getMoTa())
                .build();
    }

    public PermissionResponseDTO toResponseDTO(Permission permission) {
        return PermissionResponseDTO.builder()
                .id(permission.getId())
                .tenPermission(permission.getMaPermission())
                .moTa(permission.getDescription())
                .build();
    }
}
