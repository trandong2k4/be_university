package com.university.mapper;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.university.dto.reponse.UserResponse;
import com.university.dto.request.UserRequest;
import com.university.entity.Role;
import com.university.entity.User;
import com.university.entity.UserRole;

@Component
public class UserMapper {

    public User toEntity(UserRequest dto, PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setFullName(user.getFirstName() + " " + user.getLastName());
        response.setDateOfBirth(user.getDateOfBirth());
        response.setRoles(
                Optional.ofNullable(user.getUserRoles())
                        .orElse(Collections.emptySet())
                        .stream()
                        .map(UserRole::getRole)
                        .filter(Objects::nonNull)
                        .map(Role::getMaRole)
                        .collect(Collectors.toList()));
        return response;
    }
}