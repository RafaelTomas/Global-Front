package com.globalHealth.globalHealth.security.Jwt;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.globalHealth.globalHealth.user.UserModel;
import com.globalHealth.globalHealth.user.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JwtService implements UserDetailsService{
    final private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username){
        UserModel user = service.getUser(username);

        return new User(username, user.getPassword(), new ArrayList<>());
    }
}
