package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		StringBuffer sb = new StringBuffer();
		sb.append(userDto.getPassword());
		userEntity.setEncryptedPassword(sb.reverse().toString());

		return modelMapper.map(userRepository.save(userEntity), UserResponseModel.class);
	}

	@Override
	public List<UserResponseModel> getAllUsers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> list = userRepository.findAll();
		List<UserResponseModel> list1 = new ArrayList<>();
		for (UserEntity u : list) {
			list1.add(modelMapper.map(u, UserResponseModel.class));
		}
		return list1;
	}

}
