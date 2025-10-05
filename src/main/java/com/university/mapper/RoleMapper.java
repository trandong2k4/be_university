package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.RoleResponseDTO;
import com.university.dto.request.RoleRequestDTO;
import com.university.entity.Role;

@Component
public class RoleMapper {

    public Role toEntity(RoleRequestDTO dto) {
        return Role.builder()
                .maRole(dto.getTenRole())
                .description(dto.getMoTa())
                .build();
    }

    public RoleResponseDTO toResponseDTO(Role role) {
        return RoleResponseDTO.builder()
                .id(role.getId())
                .tenRole(role.getMaRole())
                .moTa(role.getDescription())
                .build();
    }
}
