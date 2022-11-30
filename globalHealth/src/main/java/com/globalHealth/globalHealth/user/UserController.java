package com.globalHealth.globalHealth.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;
  private final PasswordEncoder passwordEncoder;

  @GetMapping
  public ResponseEntity<List<UserModel>> getUsers() {
    return ResponseEntity.ok().body(service.getUsers());
  }

  @PostMapping("/create")
  public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
    String password = passwordEncoder.encode(user.getPassword());
    user.setPassword(password);
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/create").toUriString());
    return ResponseEntity.created(uri).body(service.saveUser(user));
  }

}
