package com.rest.rates.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rest.rates.entities.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {
	@Query
	Optional<Rate> findByType(String type);
}
