package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.SchoolClient;
import com.example.demo.dto.School;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentController {

	private final StudentService studentService;

	private SchoolClient schoolClient;

	@GetMapping
	public ResponseEntity<?> status() {
		return ResponseEntity.ok("working");
	}

	@PostMapping("/students")
	@CircuitBreaker(name = "student-service", fallbackMethod = "getDefaultSchool")
	public ResponseEntity<?> createStudent(@RequestBody Student student,
			@RequestParam("schoolName") String schoolName) {
		School school = schoolClient.getSchoolByName(schoolName);
		
		student.setSchoolName(school.getSchoolName());
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}

	public ResponseEntity<?> getDefaultSchool(Exception e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "school-service is down try after some time");
	}
}
