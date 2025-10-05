package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.UserRoleResponse;
import com.university.entity.Role;
import com.university.entity.User;
import com.university.entity.UserRole;

@Component
public class UserRoleMapper {

    public UserRole toEntity(User user, Role role) {
        UserRole ur = new UserRole();
        ur.setUser(user);
        ur.setRole(role);
        return ur;
    }

    public UserRoleResponse toResponse(UserRole ur) {
        UserRoleResponse res = new UserRoleResponse();
        res.setId(ur.getId());
        res.setUserId(ur.getUser().getId());
        res.setRoleId(ur.getRole().getId());
        res.setMaRole(ur.getRole().getMaRole());
        res.setDescription(ur.getRole().getDescription());
        return res;
    }
}