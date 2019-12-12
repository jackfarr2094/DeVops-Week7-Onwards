package com.nationwide.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.data.Achievements;
import com.nationwide.data.CarouselAchievement;
import com.nationwide.data.Criteria;
import com.nationwide.data.EmpAchievements;
import com.nationwide.data.Progress;
import com.nationwide.repo.AchievementsRepo;
import com.nationwide.repo.CriteriaRepo;
import com.nationwide.repo.EmpAchievementsRepo;
import com.nationwide.repo.EmployeesRepo;

@Component
public class EmpAchievementsService {
	
	@Autowired
	private AchievementsRepo arepo;
	
	@Autowired
	private CriteriaRepo crepo;
	
	@Autowired
	private EmpAchievementsRepo erepo;
	
	@Autowired
	private EmployeesRepo emprepo;
	
	/**
	 * Uses the Employee Achievements repository {@link erepo} to get the employee achievements.
	 * @return an ArrayList of the employee achievements in the employee achievements table.
	 */
	public ArrayList<EmpAchievements> findAll(){
		return erepo.findAll();
	}
	
	/**
	 * Uses the latest five employee achievements from {@link #erepo} (if there are less than five, it uses them all).
	 * Passes the employee number of each achievement into the {@link getName} function within {@link Employees} to get the name of the employee.
	 * Passes the achievement id of each achievement into the {@link getDescription} function within {@link #arepo} to get the achievement description.
	 * Uses the name and descriptions to create {@link CarouselAchievement} objects.
	 * @return an array of the five(or less) {@link CarouselAchievement} objects representing the five latest achievements; each containing the name of the employee and the achievement description
	 */
	public ArrayList<CarouselAchievement> latestEmpAchievements(){
		ArrayList<CarouselAchievement> carousel = new ArrayList<CarouselAchievement>();
		ArrayList<EmpAchievements> allempachievements= erepo.findAll();
		if(allempachievements.size()<5) {
			for(int i=0;i<allempachievements.size();i++) {
				String name = emprepo.getName(allempachievements.get(i).getRempno());
				String description = arepo.getDescription(allempachievements.get(i).getAchievement_id());
				CarouselAchievement thiscarousel = new CarouselAchievement(name, description);
				carousel.add(thiscarousel);
			}	
		}
		else{
			for(int j=0;j<=4;j++) {
				String name = emprepo.getName(allempachievements.get(j).getRempno());
				String description = arepo.getDescription(allempachievements.get(j).getAchievement_id());
				CarouselAchievement thiscarousel = new CarouselAchievement(name, description);
				carousel.add(thiscarousel);
			}
		}
		return carousel;
	}
	
	/**
	 * Creates an ArrayList of Strings called checkachievement, one element for each achievement in the achievements table, all initialised to say "started".
	 * Takes in the below parameters and loops through the achievements table and the employee achievements table to check which achievements this employee has achieved.
	 * If the achievement is already saved, it changes the String in checkachievement for that element to say "complete" and creates a {@link Progress} object stating that the achievement has been completed.
	 * If the achievement is not saved, therefore if that element in checkachievement still says "started", it loops through the criteria table to see if they have reached the levels required to complete the achievement.
	 * If they have, it saves the achievement in the employee achievements table, changes that element in checkachievement to say "complete", and creates a {@link Progress} object stating that the achievement has been completed.
	 * If they haven't, it compares the number of relevant cards the employee has with the number needed for each column of the criteria table for that achievement, 
	 * and returns an {@link Progress} object showing how close they are to completing the achievement.
	 * @param empno employee number
	 * @param p number of p category pride cards this employee has received
	 * @param r number of r category pride cards this employee has received
	 * @param i number of i category pride cards this employee has received
	 * @param d number of d category pride cards this employee has received
	 * @param e number of e category pride cards this employee has received
	 * @return an array list of {@link Progress} objects showing each achievement, whether the employee has achieved it, and if not how close they are to achieving it, measured in points.
	 */
	public ArrayList<Progress> saveAchievementsGetProgress(String empno,int p,int r,int i,int d,int e) {
		int pno = p;
		int rno = r;
		int ino = i;
		int dno = d;
		int eno = e;
		int ano = pno+rno+ino+dno+eno;
		ArrayList<String> checkachievement = new ArrayList<String>();
		ArrayList<Progress> allprogress = new ArrayList<Progress>();
		ArrayList<Achievements> allachievements=arepo.findAll();
		ArrayList<EmpAchievements> allsavedachievements=erepo.findAll();
		ArrayList<Criteria> allcriteria=crepo.findAll();
		for(int x=0;x<allachievements.size();x++) {
			checkachievement.add("start");
			for(int y=0;y<allsavedachievements.size();y++) {
				if(allsavedachievements.get(y).getRempno().contentEquals(empno) && allsavedachievements.get(y).getAchievement_id()==allachievements.get(x).getAchievement_id()){
					checkachievement.add(x,"complete");
					int progressachieved = 1;
					int progressbar = 1;
					int achievementno = allachievements.get(x).getAchievement_id();
					String achievementdesc = allachievements.get(x).getDescription();
					int points = allachievements.get(x).getPoints();
					int pointsachieved = allachievements.get(x).getPoints();
					Progress thisprogress = new Progress(progressbar,progressachieved,achievementno,achievementdesc,points,pointsachieved);
					allprogress.add(thisprogress);
				}
			}
			for(int z=0;z<allcriteria.size();z++) {
				if(!checkachievement.get(x).contentEquals("complete") && allachievements.get(x).getAchievement_id()==allcriteria.get(z).getAchievement_id()) {
					if(pno>=allcriteria.get(z).getP() && rno>=allcriteria.get(z).getR() && ino>=allcriteria.get(z).getI() && dno>=allcriteria.get(z).getD() && eno>=allcriteria.get(z).getE()) {
						if(ano>=(allcriteria.get(z).getA())){
							saveEmpAchievement(empno,allachievements.get(x).getAchievement_id());
							checkachievement.add(x,"complete");
							int progressachieved = 1;
							int progressbar = 1;
							int achievementno = allachievements.get(x).getAchievement_id();
							String achievementdesc = allachievements.get(x).getDescription();
							int points = allachievements.get(x).getPoints();
							int pointsachieved = allachievements.get(x).getPoints();
							Progress thisprogress = new Progress(progressbar, progressachieved,achievementno,achievementdesc,points,pointsachieved);
							allprogress.add(thisprogress);
						}
						else {
							int progressachieved= ano;
							int progressbar = allcriteria.get(z).getA();
							int achievementno = allachievements.get(x).getAchievement_id();
							String achievementdesc = allachievements.get(x).getDescription();
							int points = allachievements.get(x).getPoints();
							int pointsachieved = 0;
							Progress thisprogress = new Progress(progressbar,progressachieved,achievementno,achievementdesc,points,pointsachieved);
							allprogress.add(thisprogress);
							checkachievement.set(x, Integer.toString(progressbar));
						}
					}
					else {
						int pprogress = 0;
						int rprogress = 0;
						int iprogress = 0;
						int dprogress = 0;
						int eprogress = 0;
						int outof = 0;
						if(allcriteria.get(z).getP()>=1) {
							outof+=allcriteria.get(z).getP();
							if(pno>=allcriteria.get(z).getP()) {
								pprogress = allcriteria.get(z).getP();
							}
							else {
								pprogress = pno;
							}
						}
						if(allcriteria.get(z).getR()>=1) {
							outof+=allcriteria.get(z).getR();
							if(rno>=allcriteria.get(z).getR()) {
								rprogress = allcriteria.get(z).getR();
							}
							else {
								rprogress = rno;
							}
						}
						if(allcriteria.get(z).getI()>=1) {
							outof+=allcriteria.get(z).getI();
							if(ino>=allcriteria.get(z).getI()) {
								iprogress = allcriteria.get(z).getI();
							}
							else {
								iprogress = ino;
							}
						}
						if(allcriteria.get(z).getD()>=1) {
							outof+=allcriteria.get(z).getD();
							if(dno>=allcriteria.get(z).getD()) {
								dprogress = allcriteria.get(z).getD();
							}
							else {
								dprogress = dno;
							}
						}
						if(allcriteria.get(z).getE()>=1) {
							outof+=allcriteria.get(z).getE();
							if(eno>=allcriteria.get(z).getE()) {
								eprogress = allcriteria.get(z).getE();
							}
							else {
								eprogress = eno;
							}
						}
						int addedprogress = pprogress+rprogress+iprogress+dprogress+eprogress;
						int progressbar = outof;
						int achievementno = allachievements.get(x).getAchievement_id();
						String achievementdesc = allachievements.get(x).getDescription();
						int points = allachievements.get(x).getPoints();
						int pointsachieved = 0;
						Progress thisprogress = new Progress(progressbar,addedprogress,achievementno,achievementdesc,points,pointsachieved);
						allprogress.add(thisprogress);
						checkachievement.set(x, Integer.toString(progressbar));
					}
				}
			}
		}
		return allprogress;
	}
	
	/**
	 * Creates an ArrayList of Strings called checkachievement, one element for each achievement in the achievements table, all initialised to say "started".
	 * Takes in the below parameters and loops through the achievements table and the employee achievements table to check which achievements this employee has achieved.
	 * If the achievement is already saved, it changes the String in checkachievement for that element to say "complete".
	 * If the achievement is not saved, therefore if that element in checkachievement still says "started", it loops through the criteria table to see if they have reached the levels required to complete the achievement.
	 * If they have, it saves the achievement in the employee achievements table and changes that element in checkachievement to say "now saved".
	 * @param empno employee number
	 * @param p number of p category pride cards this employee has received
	 * @param r number of r category pride cards this employee has received
	 * @param i number of i category pride cards this employee has received
	 * @param d number of d category pride cards this employee has received
	 * @param e number of e category pride cards this employee has received
	 * @return an ArrayList of Strings called checkachievement that states which achievements the employee already had, now have achieved and are saved in the employee achievements table, and are still to achieve.
	 */
	public ArrayList<String> checkandsaveEmpAchievement(String empno,String p,String r,String i,String d,String e) {
		int pno = Integer.parseInt(p);
		int rno = Integer.parseInt(r);
		int ino = Integer.parseInt(i);
		int dno = Integer.parseInt(d);
		int eno = Integer.parseInt(e);
		int ano = pno+rno+ino+dno+eno;
		ArrayList<String> checkachievement = new ArrayList<String>();
		ArrayList<Achievements> allachievements=arepo.findAll();
		ArrayList<EmpAchievements> allsavedachievements=erepo.findAll();
		ArrayList<Criteria> allcriteria=crepo.findAll();
		for(int x=0;x<allachievements.size();x++) {
			checkachievement.add("start");
			for(int y=0;y<allsavedachievements.size();y++) {
				if(allsavedachievements.get(y).getRempno().contentEquals(empno) && allsavedachievements.get(y).getAchievement_id()==allachievements.get(x).getAchievement_id()){
					checkachievement.set(x, "already saved");
				}
			}
			for(int z=0;z<allcriteria.size();z++) {
				if(!checkachievement.get(x).contentEquals("complete") && allachievements.get(x).getAchievement_id()==allcriteria.get(z).getAchievement_id()) {
					if(pno>=allcriteria.get(z).getP() && rno>=allcriteria.get(z).getR() && ino>=allcriteria.get(z).getI() && dno>=allcriteria.get(z).getD() && eno>=allcriteria.get(z).getE()) {
						if(ano>=(allcriteria.get(z).getA())){
							saveEmpAchievement(empno,allachievements.get(x).getAchievement_id());
							checkachievement.set(x,"now saved");
						}
					}
				}
			}
		}
		return checkachievement;
	}
	
	/**
	 * Saves the achievement given into the employee achievements table.
	 * @param empno employee number
	 * @param achievementId the id of the achievement in the achievements table
	 */
	public void saveEmpAchievement(String empno, int achievementId) {
		LocalDate date = LocalDate.now();
		EmpAchievements e = new EmpAchievements(empno, achievementId, Date.valueOf(date));
		erepo.save(e);
	}

}
