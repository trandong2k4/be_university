package com.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_role", length = 30, unique = true, nullable = false)
    private String maRole;

    @Column(length = 255)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Role))
            return false;
        return Objects.equals(id, ((Role) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
