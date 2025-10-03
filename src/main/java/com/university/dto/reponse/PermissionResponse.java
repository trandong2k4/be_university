package com.university.dto.reponse;

import java.util.UUID;

public class PermissionResponse {
    private UUID id;
    private String maPermission;
    private String description;

    public PermissionResponse() {
    }

    public PermissionResponse(UUID id, String maPermission, String description) {
        this.id = id;
        this.maPermission = maPermission;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
