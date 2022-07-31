package com.mini.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
}
