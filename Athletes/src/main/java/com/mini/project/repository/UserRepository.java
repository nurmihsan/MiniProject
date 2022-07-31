package com.mini.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
