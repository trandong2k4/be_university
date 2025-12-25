package com.university.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lienhes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LienHe {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(length = 100)
    private String email;
    @Column(length = 10)
    private String soDienThoai;
    @Column(length = 255)
    private String diaChi;
    @Column(length = 100)
    private String facebook;
    @Column(length = 100)
    private String tiktok;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "truong_id", nullable = false)
    private Truong truong;
}
