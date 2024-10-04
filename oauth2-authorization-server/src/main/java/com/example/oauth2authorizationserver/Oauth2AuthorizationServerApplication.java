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
				.withUsername("bernard")
				// password is pw
				.password("{noop}pw")
				.roles("user")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}
