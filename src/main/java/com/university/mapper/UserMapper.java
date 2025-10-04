package com.university.mapper;

import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.university.dto.reponse.UserResponse;
import com.university.dto.request.UserRequest;
import com.university.entity.User;

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
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setUsername(user.getUsername());
        res.setFirstname(user.getFirstName());
        res.setLastname(user.getLastName());
        res.setRoles(user.getUserRoles().stream()
                .map(ur -> ur.getRole().getMaRole())
                .collect(Collectors.toList()));
        return res;
    }

}