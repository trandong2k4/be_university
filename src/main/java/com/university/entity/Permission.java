package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "ma_permission", unique = true, nullable = false, length = 30)
    private String maPermission;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    public Permission() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
