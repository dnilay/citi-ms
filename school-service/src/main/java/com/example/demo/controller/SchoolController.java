package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.repo.SchoolRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SchoolController {

	private final SchoolRepository schoolRepository;

	@GetMapping("/schools/{schoolName}")
	public School getSchoolByName(@PathVariable("schoolName") String schoolName) {
		return schoolRepository.findBySchoolName(schoolName);
	}
	@PostMapping("/schools")
	public ResponseEntity<?> createSchool(@RequestBody School school)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(schoolRepository.save(school));
	}

}
