package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "phonghocs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhongHoc {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_phong_hoc", length = 10, unique = true, nullable = false)
    private String maPhong;
    private String tenPhong;
    private String toaNha;
    private int tang;
    private int sucChua;
}