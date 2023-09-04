package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.UserEntity;



public interface UserRepository  {
	
	UserEntity createUser(UserEntity userEntity);
	List<UserEntity> getAllUsers();
	UserEntity findUserById(int id);
	
	

}
