package com.university.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequestDTO {

    @NotBlank(message = "Tên quyền không được để trống")
    private String tenPermission;

    private String moTa;
}