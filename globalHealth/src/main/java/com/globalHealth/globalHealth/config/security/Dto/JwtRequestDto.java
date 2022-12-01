package com.globalHealth.globalHealth.config.security.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestDto {

  private String username;
  private String password;
}