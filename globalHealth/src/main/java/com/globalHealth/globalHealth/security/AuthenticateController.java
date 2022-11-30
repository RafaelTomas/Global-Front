package com.globalHealth.globalHealth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalHealth.globalHealth.security.Dto.JwtRequestDto;
import com.globalHealth.globalHealth.security.Dto.JwtResponseDto;
import com.globalHealth.globalHealth.security.jwt.JwtTokenUtil;
import com.globalHealth.globalHealth.security.jwt.JwtUserDetailsService;
import com.globalHealth.globalHealth.user.UserModel;
import com.globalHealth.globalHealth.user.UserService;

@RestController
@RequestMapping("/login")
public class AuthenticateController {

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService userDetailsService;

  @Autowired
  private UserService userService;

  private void authenticate(String username, String password) {
    UserModel user = this.userService.getUser(username);
  }

  @PostMapping
    public ResponseEntity<JwtResponseDto> createAuthenticationToken(@RequestBody JwtRequestDto response) {
        this.authenticate(response.getUsername(), response.getPassword());

        UserModel user = this.userService.getUser(response.getUsername());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(response.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        JwtResponseDto jwtResponse = new JwtResponseDto(token);

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }
}