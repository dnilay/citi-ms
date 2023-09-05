package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor

public class UserController {

	private ModelMapper modelMapper;
	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {

		// modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserResponseModel userResponseModel = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);
	}

	@GetMapping
	public ResponseEntity<List<UserResponseModel>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{id}")

	public ResponseEntity<?> findUser(@PathVariable("id") int id) {
		// UserEntity userEntity = userRepository.findUserById(id);
		return ResponseEntity.ok(userService.findUserById(id));
	}

	@GetMapping("/find/{userId}")
	public ResponseEntity<?> getUserByUserId(@PathVariable("userId") String userId) {
		UserResponseModel userResponseModel = userService.findUserByUserId(userId);

		return ResponseEntity.ok(userResponseModel);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") String userId,
			@RequestBody UserRequestModel userRequestModel) {

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(userService.updateUserByUserId(userId, modelMapper.map(userRequestModel, UserDto.class)));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body("deletion success..");
	}
}
