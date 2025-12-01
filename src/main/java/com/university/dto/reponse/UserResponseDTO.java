package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {
    private UUID id;
    private String email;
    private String username;
    private boolean status;
    private String note;
    private LocalDate createDate;
    private LocalDate updateDate;
    private UUID roleId;
}