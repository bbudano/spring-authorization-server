package com.example.oauth2authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Oauth2AuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthorizationServerApplication.class, args);
	}

	@Bean
	UserDetailsService userDetailsService() {
		var user = User
				.withUsername("user")
				// password is pw
				.password("{bcrypt}$2a$10$IZYr0/fwFkMgs6mQ/1Sxe.efjnraHOcGmLqzvMxH/Q4VYh2amegkG")
				.roles("user")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}
