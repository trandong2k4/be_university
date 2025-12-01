package com.university.dto.request;

import java.math.BigDecimal;
import java.util.UUID;
import com.university.enums.HocLaiEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HocLaiRequestDTO {

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;

    @NotNull(message = "Môn học không được để trống")
    private UUID monHocId;

    @NotNull(message = "Kỳ học không được để trống")
    private UUID kiHocId;

    @NotBlank(message = "Lý do học lại không được để trống")
    private String lyDo;
    private int lanHoc;
    private BigDecimal diemCu;
    private HocLaiEnum trangThai;
    private String ghiChu;
}
