package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private UUID id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private boolean status;
    private String note;
    private LocalDate createDate;
    private LocalDate updateDate;
}