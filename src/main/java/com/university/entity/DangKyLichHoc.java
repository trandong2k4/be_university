package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "dangky_lichhoc", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "lichhoc_id", "sinhvien_id" })
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DangKyLichHoc {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    private LichHoc lichHoc;

    @ManyToOne
    private SinhVien sinhVien;
}