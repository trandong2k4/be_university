package com.university.mapper;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

import com.university.dto.request.UserRequestDTO;
import com.university.dto.response.UserResponseDTO;
import com.university.entity.Role;
import com.university.entity.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User toEntity(UserRequestDTO dto, Role role) {

        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .status(dto.isStatus())
                .updateDate(LocalDate.now())
                .note(dto.getNote())
                .role(role)
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
                .roleId(user.getRole().getId())
                .build();
    }
}