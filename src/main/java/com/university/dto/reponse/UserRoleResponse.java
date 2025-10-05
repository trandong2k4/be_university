package com.university.dto.reponse;

import java.util.UUID;

public class UserRoleResponse {
    private UUID id;
    private UUID userId;
    private UUID roleId;
    private String maRole;
    private String description;

    public UserRoleResponse() {
    }

    public UserRoleResponse(UUID id, UUID userId, UUID roleId, String maRole, String description) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.maRole = maRole;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
