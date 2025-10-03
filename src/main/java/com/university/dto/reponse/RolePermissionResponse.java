package com.university.dto.reponse;

import java.util.UUID;

public class RolePermissionResponse {
    private UUID id;
    private UUID roleId;
    private String maRole;
    private UUID permissionId;
    private String maPermission;
    private String description;

    public RolePermissionResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getMaRole() {
        return maRole;
    }

    public void setMaRole(String maRole) {
        this.maRole = maRole;
    }

    public UUID getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(UUID permissionId) {
        this.permissionId = permissionId;
    }

    public String getMaPermission() {
        return maPermission;
    }

    public void setMaPermission(String maPermission) {
        this.maPermission = maPermission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
