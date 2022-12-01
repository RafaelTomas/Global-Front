package com.globalHealth.globalHealth.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserModel  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "Código da pessoa")
  private Integer userId;
  @Column(nullable = false, unique = true)
  @ApiModelProperty(value = "Usuario")
  private String username;
  @Column(nullable = false)
  @ApiModelProperty(value = "Senha")
  private String password;


}