package com.university.dto.request;

import java.time.LocalDate;
import com.university.entity.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "Username không được để trống")
    private String username;
    @NotBlank(message = "Password không được để trống")
    private String password;
    private String email;
    private boolean status;
    private String note;
    private LocalDate createDate;
    private LocalDate updateDate;
    private Role role;
}