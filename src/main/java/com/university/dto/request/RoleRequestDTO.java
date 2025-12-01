package com.university.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDTO {
    @NotBlank(message = "Tên role không được để trống")
    private String tenRole;
    private String moTa;
}
