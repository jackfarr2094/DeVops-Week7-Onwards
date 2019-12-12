package com.nationwide.data;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "emp_achievements")
@NamedQuery(name = "EmpAchievements.latestEmpAchievements",
			query = "select e from EmpAchievements e ORDER BY e.date_achieved DESC")
public class EmpAchievements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_achieve_id;
	private String empno;
	private int achievement_id;
	private Date date_achieved;
	
	public EmpAchievements() {
	}

	public EmpAchievements(String rempno, int achievement_id, Date date_achieved) {
		this.empno = rempno;
		this.achievement_id = achievement_id;
		this.date_achieved = date_achieved;
	}

	public int getEmp_achieve_id() {
		return emp_achieve_id;
	}

	public void setEmp_achieve_id(int emp_achieve_id) {
		this.emp_achieve_id = emp_achieve_id;
	}

	public String getRempno() {
		return empno;
	}

	public void setRempno(String rempno) {
		this.empno = rempno;
	}

	public int getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}

	public Date getDate_achieved() {
		return date_achieved;
	}

	public void setDate_achieved(Date date_achieved) {
		this.date_achieved = date_achieved;
	}
	
}