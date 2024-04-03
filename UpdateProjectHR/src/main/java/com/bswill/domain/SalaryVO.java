package com.bswill.domain;

public class SalaryVO {

	private int employee_id;
	private int salary;
	private String bank;
	private String account;
	private String account_holder;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "SalaryVO [employee_id=" + employee_id + ", salary=" + salary + ", bank=" + bank + ", account=" + account + ", account_holder="
				+ account_holder + "]";
	}

	public String getAccount_holder() {
		return account_holder;
	}

	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}

}
