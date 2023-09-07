package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.School;

@FeignClient(name = "SCHOOL-SERVICE")
public interface SchoolClient {

	@GetMapping("/schools/{schoolName}")
	public School getSchoolByName(@PathVariable("schoolName") String schoolName);
	
}
