package com.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "permissions")
@Data
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
}
