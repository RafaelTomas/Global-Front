package com.globalHealth.globalHealth.security.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestDto {

  private String username;
  private String password;
}