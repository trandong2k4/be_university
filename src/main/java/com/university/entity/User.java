package com.university.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

  @Id
  private UUID id;

  @Column(name = "username")
  private String username;

  @Column(name = "password", length = 72, nullable = false)
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserRole> userRoles = new HashSet<>();

  public User() {
  }

  // --- Getter & Setter ---
  public UUID getId() {
    return id;
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

  public Set<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Set<UserRole> userRoles) {
    this.userRoles = userRoles;
  }
}
