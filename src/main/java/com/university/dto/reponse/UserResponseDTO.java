package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

import com.university.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private UUID id;
    private String email;
    private String username;
    private boolean status;
    private String note;
    private LocalDate createDate;
    private LocalDate updateDate;
    private Role role;

}