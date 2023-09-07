package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.SchoolClient;
import com.example.demo.dto.School;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentController {

	private final StudentService studentService;

	private SchoolClient schoolClient;
	@GetMapping
	public ResponseEntity<?> status()
	{
		return ResponseEntity.ok("working");
	}
	@PostMapping("/students")
	public ResponseEntity<?> createStudent(@RequestBody Student student,@RequestParam("schoolName") String schoolName)
	{
		School school=schoolClient.getSchoolByName(schoolName);
		student.setSchoolName(school.getSchoolName());
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}
	
	
}
