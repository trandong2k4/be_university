package com.university.dto.response;

import java.sql.Time;
import java.util.UUID;
import com.university.enums.GioiTinhEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChiTietSinhVienResponseDTO {

    private UUID id;

    private Time ngaySinh;

    private GioiTinhEnum gioiTinh;

    private String diaChi;

    private String quocTich;

    private String cccd;

    private String sdtNguoiThan;

}
