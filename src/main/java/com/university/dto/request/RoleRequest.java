package com.university.dto.request;

public class RoleRequest {
    private String maRole;
    private String description;

    public RoleRequest() {
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
