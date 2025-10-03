package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.RolePermissionResponse;
import com.university.entity.Permission;
import com.university.entity.Role;
import com.university.entity.RolePermission;

@Component
public class RolePermissionMapper {

    public RolePermission toEntity(Role role, Permission permission) {
        RolePermission rp = new RolePermission();
        rp.setRole(role);
        rp.setPermission(permission);
        return rp;
    }

    public RolePermissionResponse toResponse(RolePermission rp) {
        RolePermissionResponse res = new RolePermissionResponse();
        res.setId(rp.getId());
        res.setRoleId(rp.getRole().getId());
        res.setPermissionId(rp.getPermission().getId());
        res.setMaPermission(rp.getPermission().getMaPermission());
        return res;
    }
}
