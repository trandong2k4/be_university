package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "loaitinchi")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoaiTinChi {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "ma_loai_tin_chi", length = 10, unique = true, nullable = false)
    private String maLoaiTinChi;

    @Column(name = "ten_loai_tin_chi", length = 50, nullable = false)
    private String tenLoaiTinChi;
}
