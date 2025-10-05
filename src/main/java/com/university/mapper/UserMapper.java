package com.university.mapper;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.UserResponseDTO;
import com.university.dto.request.UserRequestDTO;
import com.university.entity.User;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }

    public UserResponseDTO toResponseDTO(User user) {
        String fullName = Stream.of(user.getFirstName(), user.getLastName())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" "));
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(fullName)
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }
}