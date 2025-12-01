package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "nganhs")
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khoa_id", nullable = false)
    private Khoa khoa;

}