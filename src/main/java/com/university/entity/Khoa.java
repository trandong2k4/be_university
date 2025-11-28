package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truong_id", nullable = false)
    @JsonBackReference
    private Truong truong;

    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Nganh> nganhs;
}