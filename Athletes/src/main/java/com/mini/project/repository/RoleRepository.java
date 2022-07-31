package com.mini.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
