package com.nationwide.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.data.Criteria;


public interface CriteriaRepo extends JpaRepository<Criteria, Integer> {
	
	public ArrayList<Criteria> findAll();
}