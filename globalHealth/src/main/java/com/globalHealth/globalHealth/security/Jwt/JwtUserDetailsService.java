package com.globalHealth.globalHealth.security.Jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.globalHealth.globalHealth.user.UserModel;
import com.globalHealth.globalHealth.user.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService service;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user = service.getUser(username);

    if (user.getUsername().equals(username)) {
      return new User(
          username, user.getPassword(),
          new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}