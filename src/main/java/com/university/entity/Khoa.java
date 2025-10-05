package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "khoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Khoa {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_khoa", length = 10, unique = true, nullable = false)
    private String maKhoa;

    @Column(name = "ten_khoa", length = 100)
    private String tenKhoa;

    @ManyToOne
    @JoinColumn(name = "truong_id", nullable = false)
    private Truong truong;

    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    private Set<Nganh> nganhs = new HashSet<>();
}