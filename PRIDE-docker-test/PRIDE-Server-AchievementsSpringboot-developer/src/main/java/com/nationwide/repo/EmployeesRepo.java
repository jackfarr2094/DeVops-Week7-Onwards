package com.nationwide.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.data.Employees;

public interface EmployeesRepo extends JpaRepository<Employees, String> {
	
	public ArrayList<Employees> findAll();
	public String getName(String rempno);
}