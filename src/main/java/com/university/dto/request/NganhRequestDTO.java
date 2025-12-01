package com.university.dto.request;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NganhRequestDTO {
    @NotNull
    private UUID id;

    @NotBlank(message = "Mã ngành không được để trống")
    private String maNganh;

    @NotBlank(message = "Tên ngành không được để trống")
    private String tenNganh;

    private UUID khoaId;

    private String tenKhoa;
}
