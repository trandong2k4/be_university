package com.university.dto.request;

public class PermissionRequest {
    private String maPermission;
    private String description;

    public PermissionRequest() {
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