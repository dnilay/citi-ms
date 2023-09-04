package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

	private final Environment environment;

	private final UserRepository userRepository;

	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		log.info("status endpoint called");
		return ResponseEntity.status(HttpStatus.OK)
				.body("user-service is up and runing on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
		log.info("within /users endpoint to create a new user");
		userEntity.setUserId(UUID.randomUUID().toString());

		UserEntity u = userRepository.createUser(userEntity);
		return new ResponseEntity<UserEntity>(u, HttpStatus.CREATED);

	}
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers()
	{
		return ResponseEntity.ok(userRepository.getAllUsers());
	}

}
