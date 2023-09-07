package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

}
