package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
	@Query
	School findBySchoolName(String schoolName);

}
