package com.example.oauth2resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
public class Oauth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResourceServerApplication.class, args);
	}

}

@RestController
class TestController {

	@GetMapping("/me")
	Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {
		return Map.of(
			"username", jwt.getSubject(),
			"scope", jwt.getClaim("scope"),
			"issuer", jwt.getClaim("iss"),
			"expiry", jwt.getClaim("exp")
		);
	}

}
