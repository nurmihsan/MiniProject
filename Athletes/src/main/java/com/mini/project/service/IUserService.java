package com.mini.project.service;

import java.util.List;

import com.mini.project.model.Role;
import com.mini.project.model.User;

public interface IUserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUser();
}
