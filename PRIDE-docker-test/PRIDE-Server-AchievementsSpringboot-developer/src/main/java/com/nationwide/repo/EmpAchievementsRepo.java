package com.nationwide.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.data.EmpAchievements;

public interface EmpAchievementsRepo extends JpaRepository<EmpAchievements, Integer> {
	
	public ArrayList<EmpAchievements> findAll();
	public ArrayList<EmpAchievements> latestEmpAchievements();
}