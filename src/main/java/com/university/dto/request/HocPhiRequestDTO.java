package com.university.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import com.university.enums.HocPhiEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HocPhiRequestDTO {

    @NotNull(message = "Sinh viên không được để trống")
    private UUID sinhVienId;

    @NotNull(message = "Kỳ học không được để trống")
    private UUID kiHocId;

    @DecimalMin(value = "0.0", inclusive = true, message = "Số tiền phải >= 0")
    private BigDecimal soTien;

    @DecimalMin(value = "0.0", inclusive = true, message = "Giá trị tín chỉ phải >= 0")
    private BigDecimal giaTriTinChi;

    private LocalDate hanThanhToan;
    private LocalDate ngayThanhToan;

    private String ghiChu;

    @NotNull(message = "Trạng thái không được để trống")
    private HocPhiEnum trangThai;
}
