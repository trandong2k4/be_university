package com.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

  @Column
  private boolean status;

  @Column(length = 255)
  private String note;

  private Time createDate;

  private Time updateDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

}
