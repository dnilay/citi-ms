package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.ui.UserResponseModel;

public interface UserService {

	UserResponseModel createUser(UserDto userDto);

	List<UserResponseModel> getAllUsers();

}
