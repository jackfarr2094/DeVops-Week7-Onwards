package com.nationwide.data;

public class Progress {
	
	private int progressbar;
	private int progressachieved;
	private int achievementno;
	private String achievementdesc;
	private int points;
	private int pointsachieved;
	
	public Progress() {
	}

	public Progress(int progressbar, int progressachieved, int achievementno, String achievementdesc, int points,
			int pointsachieved) {
		this.progressbar = progressbar;
		this.progressachieved = progressachieved;
		this.achievementno = achievementno;
		this.achievementdesc = achievementdesc;
		this.points = points;
		this.pointsachieved = pointsachieved;
	}

	public int getProgressbar() {
		return progressbar;
	}

	public void setProgressbar(int progressbar) {
		this.progressbar = progressbar;
	}

	public int getProgressachieved() {
		return progressachieved;
	}

	public void setProgressachieved(int progressachieved) {
		this.progressachieved = progressachieved;
	}

	public int getAchievementno() {
		return achievementno;
	}

	public void setAchievementno(int achievementno) {
		this.achievementno = achievementno;
	}

	public String getAchievementdesc() {
		return achievementdesc;
	}

	public void setAchievementdesc(String achievementdesc) {
		this.achievementdesc = achievementdesc;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPointsachieved() {
		return pointsachieved;
	}

	public void setPointsachieved(int pointsachieved) {
		this.pointsachieved = pointsachieved;
	}
	
}
