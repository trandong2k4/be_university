package com.university.mapper;

import com.university.dto.UserDTO;
import com.university.entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth());
    }
}
