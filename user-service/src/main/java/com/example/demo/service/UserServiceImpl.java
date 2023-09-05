package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
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
		// modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		StringBuffer sb = new StringBuffer();
		sb.append(userDto.getPassword());
		userEntity.setEncryptedPassword(sb.reverse().toString());

		return modelMapper.map(userRepository.save(userEntity), UserResponseModel.class);
	}

	@Override
	public List<UserResponseModel> getAllUsers() {
		// modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> list = userRepository.findAll();
		List<UserResponseModel> list1 = new ArrayList<>();
		for (UserEntity u : list) {
			list1.add(modelMapper.map(u, UserResponseModel.class));
		}
		return list1;
	}

	@Override
	public UserResponseModel findUserById(int id) {
		Optional<UserEntity> userEntity=userRepository.findById(id);
		return modelMapper.map(userEntity, UserResponseModel.class);
	}

	@Override
	public UserResponseModel findUserByUserId(String userId) {
		// TODO Auto-generated method stub
		UserEntity userEntity=userRepository.findByUserId(userId);
		if(userEntity==null)
		{
			throw new UserNotFoundException("user with "+userId+" not found");
		}
		return modelMapper.map(userEntity, UserResponseModel.class);
	}

}
