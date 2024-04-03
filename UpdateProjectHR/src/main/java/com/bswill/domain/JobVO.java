package com.bswill.domain;

public class JobVO {

	private int JOB_ID;
	private String JOB;
	private double ratio_bonus;
	private double ratio_premium;

	public int getJOB_ID() {
		return JOB_ID;
	}

	public void setJOB_ID(int jOB_ID) {
		JOB_ID = jOB_ID;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public double getRatio_bonus() {
		return ratio_bonus;
	}

	public void setRatio_bonus(double ratio_bonus) {
		this.ratio_bonus = ratio_bonus;
	}

	public double getRatio_premium() {
		return ratio_premium;
	}

	public void setRatio_premium(double ratio_premium) {
		this.ratio_premium = ratio_premium;
	}

	@Override
	public String toString() {
		return "JobVO [JOB_ID=" + JOB_ID + ", JOB=" + JOB + ", ratio_bonus=" + ratio_bonus + ", ratio_premium=" + ratio_premium + "]";
	}

}
