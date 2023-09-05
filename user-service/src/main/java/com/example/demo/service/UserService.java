package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.ui.UserResponseModel;

public interface UserService {

	UserResponseModel createUser(UserDto userDto);

	List<UserResponseModel> getAllUsers();

	UserResponseModel findUserById(int id);

	UserResponseModel findUserByUserId(String userId);
	
	UserResponseModel updateUserByUserId(String userId,UserDto userDto);
	void deleteUser(String userId);

}
