package com.spring.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements java.io.Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Email(message = "Provide valid email")
  @NotEmpty(message = "Email is required")
  @NotNull(message = "Email cannot be null")
  @Column(name = "email")
  private String email;

  @NotEmpty(message = "Password is required")
  @NotNull(message = "Password cannot be null")
  @Column(name = "password")
  private String password;

  @NotEmpty(message = "Username is required")
  @NotNull(message = "Password cannot be null")
  @Column(name = "username")
  private String username;

  protected User() {}

  public User(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public Long getId() {
    return id;
  }
}
