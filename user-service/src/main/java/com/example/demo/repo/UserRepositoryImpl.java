package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserEntity;

@Component("userRepository")
public class UserRepositoryImpl implements UserRepository {

	private final EntityManager entityManager;

	public UserRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public UserEntity createUser(UserEntity userEntity) {

		entityManager.persist(userEntity);
		return userEntity;
	}

	@Override
	@Transactional
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		TypedQuery<UserEntity> query = entityManager.createQuery("FROM UserEntity U", UserEntity.class);

		return query.getResultList();
	}

	@Override
	@Transactional
	public UserEntity findUserById(int id) {
		UserEntity userEntity = entityManager.find(UserEntity.class, id);
		if (userEntity == null) {
			throw new UserNotFoundException("user with " + id + " not found");
		} else {
			return userEntity;
		}

	}

}
