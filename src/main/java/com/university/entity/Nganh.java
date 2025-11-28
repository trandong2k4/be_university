package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "nganhs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nganh {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_nganh", length = 10, unique = true, nullable = false)
    private String maNganh;

    @Column(name = "ten_nganh", length = 100)
    private String tenNganh;

    @OneToMany(mappedBy = "nganh", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SinhVien> sinhViens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khoa_id", nullable = false)
    @JsonBackReference
    private Khoa khoa;

}