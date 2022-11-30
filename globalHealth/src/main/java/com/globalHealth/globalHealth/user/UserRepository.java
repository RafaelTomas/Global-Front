package com.globalHealth.globalHealth.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
  UserModel findByUsername(String username);
  UserModel findByUserId(Integer id);
  
}
