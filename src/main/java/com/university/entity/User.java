package com.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@Data
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

  @Column(columnDefinition = "DATE")
  private LocalDate createDate;

  @Column(columnDefinition = "DATE")
  private LocalDate updateDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

  // 1 user -> 1 sinh viên
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private SinhVien sinhVien;

  // 1 user -> 1 giảng viên
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private GiangVien giangVien;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private NhanVien nhanVien;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<BaiViet> baiViets;
}
