package com.ashutosh.carmanagementapi;

import com.ashutosh.carmanagementapi.model.ReclaimNumber;
import com.ashutosh.carmanagementapi.model.Role;
import com.ashutosh.carmanagementapi.model.User;
import com.ashutosh.carmanagementapi.repository.ReclaimNumberRepository;
import com.ashutosh.carmanagementapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	* Using CommandLineRunner to create ADMIN user upon booting the project
	*/
	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository) {
		return args -> repository.save(
				new User("admin@gmail.com", passwordEncoder.encode("P@ssword123"), Role.ADMIN)
		);
	}

	@Bean
	CommandLineRunner commandLineRunner2(ReclaimNumberRepository repository) {
		ReclaimNumber number = new ReclaimNumber();
		number.setDid("123");
		number.setStatus(ReclaimStatus.SUCCESS);
		number.setStatusCode("200");
		number.setStatusDesc("OK");
		number.setProviderName("DIDWW");
		return args -> repository.save(number);
	}

}
