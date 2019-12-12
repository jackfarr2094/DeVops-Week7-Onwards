package com.nationwide.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.data.Achievements;
import com.nationwide.data.Criteria;
import com.nationwide.repo.AchievementsRepo;
import com.nationwide.repo.CriteriaRepo;
import com.nationwide.repo.EmpAchievementsRepo;


@Component
public class AchievementsService {
	
	@Autowired
	private AchievementsRepo arepo;
	
	@Autowired
	private CriteriaRepo crepo;
	
	@Autowired
	private EmpAchievementsRepo erepo;
	
	/**
	 * Uses the Achievements repository {@link arepo} to get the achievements.
	 * @return an ArrayList of the achievements in the achievements table.
	 */
	public ArrayList<Achievements> getAllAchievements() {
		return arepo.findAll();
	}
	
	/**
	 * Creates a new achievement from the description and number of points passed in and saves this in the achievements table.
	 * Gets the id of this new achievement and creates a new criteria object from this and the other parameters, and then saves this in the criteria table.
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
	public String saveAchievement(String description, int points, int p, int r, int i, int d, int e, int a) {
		String returnString = "";
		Achievements ach = new Achievements(description, points);
		try {
			arepo.save(ach);
			returnString+="Achievement saved";
		}
		catch (Exception achievementexc) {
			System.out.println("Achievement exception:"+achievementexc);
		}
		int achievementid = arepo.findMaxAchievement_id();
		Criteria c = new Criteria(achievementid, p, r, i, d, e, a);
		try {
			crepo.save(c);
			returnString+="Criteria saved";
		}
		catch (Exception criteriaexc) {
			System.out.println("Criteria exception:"+criteriaexc);
		}
		return returnString;
	}
}
