package com.university.dto.reponse;

import java.util.Set;
import java.util.UUID;

public class RoleResponse {
    private UUID id;
    private String maRole;
    private String description;
    private Set<String> permissionNames; // Trả về tên permission

    public RoleResponse() {
    }

    public RoleResponse(UUID id, String maRole, String description, Set<String> permissionNames) {
        this.id = id;
        this.maRole = maRole;
        this.description = description;
        this.permissionNames = permissionNames;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Set<String> getPermissionNames() {
        return permissionNames;
    }

    public void setPermissionNames(Set<String> permissionNames) {
        this.permissionNames = permissionNames;
    }

}
