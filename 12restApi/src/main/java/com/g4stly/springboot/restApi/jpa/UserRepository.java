package com.g4stly.springboot.restApi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g4stly.springboot.restApi.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
