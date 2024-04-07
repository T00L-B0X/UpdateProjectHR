package com.bswill.domain;

import java.sql.Date;
import java.util.List;

public class AppointmentVO {

	private int employee_id;
	private String app_issue;
	private String app_content;
	private Date app_date;
	private List<AppointmentVO> aList;

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

	public Date getApp_date() {
		return app_date;
	}

	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}

	public List<AppointmentVO> getaList() {
		return aList;
	}

	public void setaList(List<AppointmentVO> aList) {
		this.aList = aList;
	}

	@Override
	public String toString() {
		return "AppointmentVO [employee_id=" + employee_id + ", app_issue=" + app_issue + ", app_content=" + app_content
				+ ", app_date=" + app_date + ", aList=" + aList + "]";
	}

}
