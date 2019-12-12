package com.nationwide.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.data.Achievements;

public interface AchievementsRepo extends JpaRepository<Achievements, Integer> {
	
	public ArrayList<Achievements> findAll();
	public int findMaxAchievement_id();
	public String getDescription(int achievement_id);
}