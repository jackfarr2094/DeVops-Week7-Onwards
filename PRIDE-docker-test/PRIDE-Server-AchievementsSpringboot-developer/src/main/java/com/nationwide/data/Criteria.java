package com.nationwide.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria")
public class Criteria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int criteria_id;
	private int achievement_id;
	private int p;
	private int r;
	private int i;
	private int d;
	private int e;
	private int a;
	
	public Criteria() {
	}

	public Criteria(int achievement_id, int p, int r, int i, int d, int e, int a) {
		this.achievement_id = achievement_id;
		this.p = p;
		this.r = r;
		this.i = i;
		this.d = d;
		this.e = e;
		this.a = a;
	}

	public Criteria(int criteria_id, int achievement_id, int p, int r, int i, int d, int e, int a) {
		super();
		this.criteria_id = criteria_id;
		this.achievement_id = achievement_id;
		this.p = p;
		this.r = r;
		this.i = i;
		this.d = d;
		this.e = e;
		this.a = a;
	}

	public int getCriteria_id() {
		return criteria_id;
	}

	public void setCriteria_id(int criteria_id) {
		this.criteria_id = criteria_id;
	}

	public int getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}