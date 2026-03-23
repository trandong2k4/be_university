package com.university.dto.request;

import java.sql.Time;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienRequestDTO {

    private String maSinhVien;

    private String hoTen;

    private String soDienThoai;

    private Time ngayNhapHoc;

    private Time ngayTotNghiep;

    private UUID nganhId;

    private UUID userId;

}
