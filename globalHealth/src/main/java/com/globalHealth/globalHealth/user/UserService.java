package com.globalHealth.globalHealth.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService  {

  private final UserRepository repository;

  public UserModel saveUser(UserModel user) {
    return repository.save(user);
  }

  public UserModel getUser(String username) {
    return repository.findByUsername(username);
  }

  public List<UserModel> getUsers() {
    return repository.findAll();
  }


  
}
