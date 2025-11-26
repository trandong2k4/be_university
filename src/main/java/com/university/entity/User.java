package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Objects;
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

  @Column(name = "username", length = 30, unique = true, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String password;

  @Column(length = 50)
  private String email;

  @Column(length = 30)
  private String firstName;

  @Column(length = 30)
  private String lastName;

  @Column
  private boolean status;

  @Column(length = 255)
  private String note;

  @Column(columnDefinition = "DATE")
  private LocalDate createDate;
  
  @Column(columnDefinition = "DATE")
  private LocalDate updateDate;

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
