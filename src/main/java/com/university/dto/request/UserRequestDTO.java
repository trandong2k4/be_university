package com.university.dto.request;

import java.sql.Time;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Username không được để trống")
    private String username;
    private String password;
    private String email;
    private boolean status;
    private Time create_at;
    private Time upDate_at;
    private String note;
    private UUID roleId;
}