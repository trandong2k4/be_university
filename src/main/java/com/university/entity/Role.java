package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 30, unique = true, nullable = false)
    private String maRole;

    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<RolePermission> rolePermissions = new HashSet<>();

    public Role() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

}
