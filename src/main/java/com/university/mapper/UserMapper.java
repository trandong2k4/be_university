package com.university.mapper;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.university.dto.reponse.UserResponseDTO;
import com.university.dto.request.UserRequestDTO;
import com.university.entity.Role;
import com.university.entity.User;
import com.university.exception.ResourceNotFoundException;
import com.university.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
    RoleRepository roleRepository;

    public User toEntity(UserRequestDTO dto) {
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy vai trò"));

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