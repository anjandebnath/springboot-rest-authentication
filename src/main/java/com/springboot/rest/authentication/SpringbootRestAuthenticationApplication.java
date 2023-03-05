package com.springboot.rest.authentication;

import com.springboot.rest.authentication.model.ERole;
import com.springboot.rest.authentication.model.Role;
import com.springboot.rest.authentication.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRestAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestAuthenticationApplication.class, args);
	}

	//Preload the data to insert into database

	@Bean
	public CommandLineRunner roleLoader(RoleRepository repo) {
		return args -> {
			repo.save(new Role(ERole.ROLE_ADMIN));
			repo.save(new Role(ERole.ROLE_USER));
		};
	}

}
