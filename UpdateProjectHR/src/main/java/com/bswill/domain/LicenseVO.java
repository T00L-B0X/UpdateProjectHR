package com.bswill.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class LicenseVO {

	private int employee_id;
	private String license;
	private String li_org;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String li_date;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLi_org() {
		return li_org;
	}

	public void setLi_org(String li_org) {
		this.li_org = li_org;
	}

	public String getLi_date() {
		return li_date;
	}

	public void setLi_date(String li_date) {
		this.li_date = li_date;
	}

	@Override
	public String toString() {
		return "LicenseVO [employee_id=" + employee_id + ", license=" + license + ", li_org=" + li_org + ", li_date=" + li_date + "]";
	}

}
