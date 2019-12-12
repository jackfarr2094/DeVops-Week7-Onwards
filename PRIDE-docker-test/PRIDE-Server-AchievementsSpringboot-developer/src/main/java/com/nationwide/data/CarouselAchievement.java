package com.nationwide.data;

public class CarouselAchievement {
	
	private String name;
	private String achievement;
	
	public CarouselAchievement() {
	}

	public CarouselAchievement(String name, String achievement) {
		this.name = name;
		this.achievement = achievement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

}
