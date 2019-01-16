package com.sanan.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sanan.demo.data.entity.User;
import com.sanan.demo.data.repository.UserRepository;

@SpringBootApplication
public class SananApplication {

	public static void main(String[] args) {
		SpringApplication.run(SananApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository) throws Exception {
		return (args) -> {
			User user = new User();
			user.setId("sanan");
			user.setPassword("$2a$10$l7yyCFPFmkmce8C1tFBqGeVkKc/UlxCT8eKrZuMqEzDbMnClaeUP2");
			userRepository.save(user);
		};
	}
	
}

