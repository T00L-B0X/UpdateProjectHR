package com.bswill.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentVO {

	private int employee_id;
	private String app_issue;
	private String app_content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String app_date;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getApp_issue() {
		return app_issue;
	}

	public void setApp_issue(String app_issue) {
		this.app_issue = app_issue;
	}

	public String getApp_content() {
		return app_content;
	}

	public void setApp_content(String app_content) {
		this.app_content = app_content;
	}

	public String getApp_date() {
		return app_date;
	}

	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}

	@Override
	public String toString() {
		return "AppointmentVO [employee_id=" + employee_id + ", app_issue=" + app_issue + ", app_content=" + app_content + ", app_date=" + app_date
				+ "]";
	}

}
