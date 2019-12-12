package com.nationwide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.data.CarouselAchievement;
import com.nationwide.data.EmpAchievements;
import com.nationwide.data.Progress;
import com.nationwide.service.EmpAchievementsService;
import com.nationwide.data.Employees;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmpAchievementsController {
	
	@Autowired
	private EmpAchievementsService service;
	
	/**
	 * Calls the function findAll within {@link EmpAchievementsService}
	 * @return an ArrayList of {@link EmpAchievements} objects from the EmpAchievements table.
	 */
	@GetMapping("/emp_achievements/all")
	public ArrayList<EmpAchievements> findAll(){
		return service.findAll();
	}
	
	/**
	 * Calls the function latestEmpAchievements within {@link EmpAchievementsService}
	 * @return an array of the five(or less) {@link CarouselAchievement} objects representing the five latest achievements; each containing the name of the employee and the achievement description
	 */
	@GetMapping("/emp_achievements/carousel")
	public ArrayList<CarouselAchievement> latestEmpAchievements(){
		return service.latestEmpAchievements();
	}
	
	/**
	 * Passes the information to the saveAchievementsGetProgress function within {@link EmpAchievementsService}
	 * @param empno employee number
	 * @param p number of p category pride cards this employee has received
	 * @param r number of r category pride cards this employee has received
	 * @param i number of i category pride cards this employee has received
	 * @param d number of d category pride cards this employee has received
	 * @param e number of e category pride cards this employee has received
	 * @return an array list of {@link Progress} objects showing each achievement, whether the employee has achieved it, and if not how close they are to achieving it, measured in points.
	 */
	@GetMapping("/emp_achievements/{empno}/{p}/{r}/{i}/{d}/{e}")
	public ArrayList<Progress> saveAchievementsGetProgress(
			@PathVariable String empno,
			@PathVariable int p,
			@PathVariable int r,
			@PathVariable int i,
			@PathVariable int d,
			@PathVariable int e) {
		return service.saveAchievementsGetProgress(empno,p,r,i,d,e);		
	}
	
	/**
	 * Passes the information to the checkandsaveEmpAchievement function within {@link EmpAchievementsService}
	 * @param empno employee number
	 * @param p number of p category pride cards this employee has received
	 * @param r number of r category pride cards this employee has received
	 * @param i number of i category pride cards this employee has received
	 * @param d number of d category pride cards this employee has received
	 * @param e number of e category pride cards this employee has received
	 * @return an ArrayList of Strings called checkachievement that states which achievements the employee already had, now have achieved and are saved in the employee achievements table, and are still to achieve.
	 */
	@PostMapping("/emp_achievements/{empno}/{p}/{r}/{i}/{d}/{e}")
	public ArrayList<String> checkandsaveEmpAchievements(
			@PathVariable String empno,
			@PathVariable String p,
			@PathVariable String r,
			@PathVariable String i,
			@PathVariable String d,
			@PathVariable String e) {
		return service.checkandsaveEmpAchievement(empno,p,r,i,d,e);		
	}

}
