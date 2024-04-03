package com.bswill.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class SalarylistVO {

	private int employee_id;
	@DateTimeFormat(pattern = "yyyy-MM")
	private String pay_yearmonth;
	private int JOB_ID;
	private int salary;
	private int bonus;
	private int premium;
	private int sum;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getPay_yearmonth() {
		return pay_yearmonth;
	}

	public void setPay_yearmonth(String pay_yearmonth) {
		this.pay_yearmonth = pay_yearmonth;
	}

	public int getJOB_ID() {
		return JOB_ID;
	}

	public void setJOB_ID(int jOB_ID) {
		JOB_ID = jOB_ID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SalarylistVO [employee_id=" + employee_id + ", pay_yearmonth=" + pay_yearmonth + ", JOB_ID=" + JOB_ID + ", salary=" + salary
				+ ", bonus=" + bonus + ", premium=" + premium + ", sum=" + sum + "]";
	}

}
