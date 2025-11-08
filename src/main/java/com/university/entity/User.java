package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(name = "username", columnDefinition = "VARCHAR(30)", unique = true, nullable = false)
  private String username; // Nếu username có thể chứa tiếng Việt, sử dụng NVARCHAR

  @Column(columnDefinition = "VARCHAR(200)", nullable = false) // Password thường không cần Unicode
  private String password;

  @Column(columnDefinition = "VARCHAR(100)")
  private String email;

  @Column(columnDefinition = "NVARCHAR(30)") // Hỗ trợ tiếng Việt cho tên
  private String firstName;

  @Column(columnDefinition = "NVARCHAR(30)") // Hỗ trợ tiếng Việt cho họ
  private String lastName;

  @Column(columnDefinition = "DATE")
  private LocalDate dateOfBirth;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

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
