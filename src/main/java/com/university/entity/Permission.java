package com.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_permission", length = 30, unique = true, nullable = false)
    private String maPermission;

    @Column(length = 255, columnDefinition = "VARCHAR(255)")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Permission))
            return false;
        return Objects.equals(id, ((Permission) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
