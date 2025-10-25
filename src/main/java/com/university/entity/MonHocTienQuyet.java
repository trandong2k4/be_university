package com.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "monhoc_tienquyet", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "monhoc_id", "monhoc_tienquyet_id" })
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonHocTienQuyet {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "monhoc_id", nullable = false)
    @JsonIgnore
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "monhoc_tienquyet_id", nullable = false)
    private MonHoc monHocTienQuyet;
}