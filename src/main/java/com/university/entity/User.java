package com.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(length = 30, unique = true, nullable = false)
  private String username;

  @Column(length = 72, nullable = false)
  private String password;

  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  @JsonIgnoreProperties("users") // tránh vòng lặp JSON
  private Set<Role> roles = new HashSet<>();

  // equals / hashCode chỉ dùng id
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof User))
      return false;
    return Objects.equals(id, ((User) o).id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
