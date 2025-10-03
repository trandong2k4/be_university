package com.university.dto.request;

import java.time.LocalDate;
import java.util.Set;

import com.university.entity.Role;

public class RegisterRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Set<Role> ma_role;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password, String firstName, String lastName, LocalDate dateOfBirth,
            Set<Role> ma_role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ma_role = ma_role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Role> getMa_role() {
        return ma_role;
    }

    public void setMa_role(Set<Role> ma_role) {
        this.ma_role = ma_role;
    }
}
