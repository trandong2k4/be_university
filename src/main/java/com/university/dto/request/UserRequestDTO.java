package com.university.dto.request;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Username không được để trống")
    private String username;
    @NotBlank(message = "Password không được để trống")
    private String password;
    private String email;
    private boolean status;
    private LocalDate create_at;
    private LocalDate upDate_at;
    private String note;
    private UUID roleId;
}