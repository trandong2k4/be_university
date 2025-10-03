package com.university.mapper;

import org.springframework.stereotype.Component;

import com.university.dto.reponse.PermissionResponse;
import com.university.dto.request.PermissionRequest;
import com.university.entity.Permission;

@Component
public class PermissionMapper {

    public Permission toEntity(PermissionRequest dto) {
        Permission permission = new Permission();
        permission.setMaPermission(dto.getMaPermission());
        permission.setDescription(dto.getDescription());
        return permission;
    }

    public void updateEntity(Permission permission, PermissionRequest dto) {
        permission.setMaPermission(dto.getMaPermission());
        permission.setDescription(dto.getDescription());
    }

    public PermissionResponse toResponse(Permission permission) {
        PermissionResponse response = new PermissionResponse();
        response.setId(permission.getId());
        response.setMaPermission(permission.getMaPermission());
        response.setDescription(permission.getDescription());
        return response;
    }
}
