package com.vs.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 
}
