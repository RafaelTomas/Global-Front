package com.globalHealth.globalHealth.security.jwt;

import com.globalHealth.globalHealth.user.UserModel;
import com.globalHealth.globalHealth.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService service;

  @Override
    public UserDetails loadUserByUsername(String username)  {
        UserModel user = this.service.getUser(username);

        return new User(username, user.getPassword(), new ArrayList<>());
    }
}