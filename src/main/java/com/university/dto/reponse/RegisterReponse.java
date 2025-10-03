package com.university.dto.reponse;

import java.time.LocalDate;
import java.util.UUID;

public class RegisterReponse {
    private UUID id;
    private String username;
    private String fullName;
    private LocalDate dateOfBirth;

    public RegisterReponse() {
    }

    public RegisterReponse(UUID id, String username, String fullName, LocalDate dateOfBirth) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
