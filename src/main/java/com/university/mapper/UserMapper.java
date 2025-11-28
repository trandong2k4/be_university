package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.UserResponseDTO;
import com.university.dto.request.UserRequestDTO;
import com.university.entity.User;
import com.university.service.auth.RoleService;

@Component
public class UserMapper {
    RoleService roleService;

    public User toEntity(UserRequestDTO dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .status(dto.isStatus())
                .note(dto.getNote())
                .createDate(dto.getCreateDate())
                .updateDate(dto.getUpdateDate())
                .role(dto.getRole())
                .build();
    }

    public UserResponseDTO toResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .status(user.isStatus())
                .note(user.getNote())
                .createDate(user.getCreateDate())
                .updateDate(user.getUpdateDate())
                .build();
    }
}