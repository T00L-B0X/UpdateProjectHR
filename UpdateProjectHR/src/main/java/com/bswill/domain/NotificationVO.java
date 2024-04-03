package com.bswill.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class NotificationVO {

	private int employee_id;
	private String noti_title;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String noti_time;
	private String noti_check;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String read_time;
	private String noti_link;
	private String noti_print;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getNoti_title() {
		return noti_title;
	}

	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}

	public String getNoti_time() {
		return noti_time;
	}

	public void setNoti_time(String noti_time) {
		this.noti_time = noti_time;
	}

	public String getNoti_check() {
		return noti_check;
	}

	public void setNoti_check(String noti_check) {
		this.noti_check = noti_check;
	}

	public String getRead_time() {
		return read_time;
	}

	public void setRead_time(String read_time) {
		this.read_time = read_time;
	}

	public String getNoti_link() {
		return noti_link;
	}

	public void setNoti_link(String noti_link) {
		this.noti_link = noti_link;
	}

	public String getNoti_print() {
		return noti_print;
	}

	public void setNoti_print(String noti_print) {
		this.noti_print = noti_print;
	}

	@Override
	public String toString() {
		return "NotificationVO [employee_id=" + employee_id + ", noti_title=" + noti_title + ", noti_time=" + noti_time + ", noti_check=" + noti_check
				+ ", read_time=" + read_time + ", noti_link=" + noti_link + ", noti_print=" + noti_print + "]";
	}

}
