package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.RoleResponse;
import com.university.dto.request.RoleRequest;
import com.university.entity.Role;

@Component
public class RoleMapper {

    public Role toEntity(RoleRequest dto) {
        Role role = new Role();
        role.setMaRole(dto.getMaRole());
        role.setDescription(dto.getDescription());
        return role;
    }

    public RoleResponse toResponse(Role role) {
        RoleResponse res = new RoleResponse();
        res.setId(role.getId());
        res.setMaRole(role.getMaRole());
        res.setDescription(role.getDescription());
        return res;
    }
}
