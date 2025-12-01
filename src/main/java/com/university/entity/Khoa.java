package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "khoas")
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "truong_id", nullable = false)
    private Truong truong;

}