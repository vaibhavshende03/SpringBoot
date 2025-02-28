package com.vs.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.main.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
 User findByEmail(String email);
}
