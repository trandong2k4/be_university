package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 30, unique = true, nullable = false)
    private String maPermission;

    private String description;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
    private Set<RolePermission> rolePermissions = new HashSet<>();

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

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

}
