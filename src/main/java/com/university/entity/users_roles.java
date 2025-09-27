package com.university.entity;

import java.util.UUID;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "users_roles")
public class users_roles {

    private UUID user_id;
    private UUID role_id;

    public users_roles() {
    }

    public users_roles(final UUID user_id, final UUID role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public UUID getRole_id() {
        return this.role_id;
    }

    public void setRole_id(UUID role_id) {
        this.role_id = role_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getUser_id() {
        return this.user_id;
    }

    @Override
    public String toString() {
        return "users_roles [user_id=" + getUser_id() + ", role_id=" + getRole_id() + "]";
    }

}
