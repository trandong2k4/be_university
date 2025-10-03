package com.university.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "monhoc_tienquyet")
public class MonHocTienQuyet {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "monhoc_id", nullable = false)
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "monhoc_tienquyet_id", nullable = false)
    private MonHoc monHocTienQuyet;

    public MonHocTienQuyet() {
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MonHoc getMonHocTienQuyet() {
        return monHocTienQuyet;
    }

    public void setMonHocTienQuyet(MonHoc monHocTienQuyet) {
        this.monHocTienQuyet = monHocTienQuyet;
    }
}
