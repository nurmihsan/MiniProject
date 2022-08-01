package com.mini.project;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mini.project.model.Role;
import com.mini.project.model.User;
import com.mini.project.service.IUserService;

@SpringBootApplication
public class AthletesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthletesApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	};
	
		@Bean
		CommandLineRunner run(IUserService userService) {
			return args -> {
				userService.saveRole(new Role(null, "ROLE_USER"));
				userService.saveRole(new Role(null, "ROLE_MANAGER"));
				userService.saveRole(new Role(null, "ROLE_ADMIN"));
				userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
				
				userService.saveUser(new User(null, "Conor Mcgregor", "conor", "1234", new ArrayList<>()));
				userService.saveUser(new User(null, "Khabib Nurmagedov", "habib", "1234", new ArrayList<>()));
				userService.saveUser(new User(null, "Ronda Rousey", "ronda", "1234", new ArrayList<>()));
				userService.saveUser(new User(null, "Jon Jondes", "jon", "1234", new ArrayList<>()));
			
				userService.addRoleToUser("conor", "ROLE_USER");
				userService.addRoleToUser("habib", "ROLE_ADMIN");
				userService.addRoleToUser("habib", "ROLE_MANAGER");
				userService.addRoleToUser("jon", "ROLE_SUPER_ADMIN");
				userService.addRoleToUser("ronda", "ROLE_MANAGER");
				userService.addRoleToUser("jon", "ROLE_ADMIN");
			};
		}

}
