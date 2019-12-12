package com.nationwide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.data.Achievements;
import com.nationwide.service.AchievementsService;
import com.nationwide.service.EmpAchievementsService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AchievementsController {
	
	@Autowired
	private AchievementsService service;
	
	/**
	 * Calls the function getAllAchievements within {@link AchievementsService}
	 * @return an ArrayList of {@link Achievement} objects from the achievements table
	 */
	@GetMapping("/achievements/all")
	public ArrayList<Achievements> getAllAchievements(){
		return service.getAllAchievements();
	}
	
	/**
	 * Passes the information to the saveAchievement method within {@link AchievementsService}
	 * @param description the description of the achievement to be saved.
	 * @param points the number of points that will be gained from completing the achievement.
	 * @param p the number of p category pride cards needed to obtain this achievement.
	 * @param r the number of r category pride cards needed to obtain this achievement.
	 * @param i the number of i category pride cards needed to obtain this achievement.
	 * @param d the number of d category pride cards needed to obtain this achievement.
	 * @param e the number of e category pride cards needed to obtain this achievement.
	 * @param a the overall number of any cards need to obtain this achievement if the criteria is not for a particular number of p/r/i/d/e cards.
	 * @return a string confirming the achievement and corresponding criteria have been successfully saved.
	 */
	@PostMapping("/achievements/{description}/{points}/{p}/{r}/{i}/{d}/{e}/{a}")
	public String saveAchievement(
			@PathVariable String description,
			@PathVariable int points,
			@PathVariable int p,
			@PathVariable int r,
			@PathVariable int i,
			@PathVariable int d,
			@PathVariable int e,
			@PathVariable int a){
		return service.saveAchievement(description,points,p,r,i,d,e,a);
	}

}
