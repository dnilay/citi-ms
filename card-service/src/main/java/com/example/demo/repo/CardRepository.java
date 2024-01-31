package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Card;
@Repository
public interface CardRepository extends JpaRepository<Card, String>{

}
