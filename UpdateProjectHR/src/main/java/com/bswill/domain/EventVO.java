package com.bswill.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class EventVO {

	private int employee_id;
	private String eve_class;
	private String eve_subject;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String eve_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String req_date;
	private int eve_amount;
	private String eve_auth;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEve_class() {
		return eve_class;
	}

	public void setEve_class(String eve_class) {
		this.eve_class = eve_class;
	}

	public String getEve_subject() {
		return eve_subject;
	}

	public void setEve_subject(String eve_subject) {
		this.eve_subject = eve_subject;
	}

	public String getEve_date() {
		return eve_date;
	}

	public void setEve_date(String eve_date) {
		this.eve_date = eve_date;
	}

	public String getReq_date() {
		return req_date;
	}

	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}

	public int getEve_amount() {
		return eve_amount;
	}

	public void setEve_amount(int eve_amount) {
		this.eve_amount = eve_amount;
	}

	public String getEve_auth() {
		return eve_auth;
	}

	public void setEve_auth(String eve_auth) {
		this.eve_auth = eve_auth;
	}

	@Override
	public String toString() {
		return "EventVO [employee_id=" + employee_id + ", eve_class=" + eve_class + ", eve_subject=" + eve_subject + ", eve_date=" + eve_date
				+ ", req_date=" + req_date + ", eve_amount=" + eve_amount + ", eve_auth=" + eve_auth + "]";
	}

}
