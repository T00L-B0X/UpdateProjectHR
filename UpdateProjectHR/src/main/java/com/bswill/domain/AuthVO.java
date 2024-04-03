package com.bswill.domain;

public class AuthVO {

	private int employee_id;
	private String auth;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "AuthVO [employee_id=" + employee_id + ", auth=" + auth + "]";
	}

}
