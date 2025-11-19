package com.university.dto.request;

import java.time.LocalDate;
import com.university.entity.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Username không được để trống")
    private String username;
    @NotBlank(message = "Password không được để trống")
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean status;
    private LocalDate createDate;
    private Role role;
}