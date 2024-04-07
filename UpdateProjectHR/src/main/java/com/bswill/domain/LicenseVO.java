package com.bswill.domain;

import java.sql.Date;
import java.util.List;

public class LicenseVO {

	private int employee_id;
	private String license;
	private String li_org;
	private Date li_date;
	private List<LicenseVO> lList;

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

	public Date getLi_date() {
		return li_date;
	}

	public void setLi_date(Date li_date) {
		this.li_date = li_date;
	}

	public List<LicenseVO> getLList() {
		return lList;
	}

	public void setLList(List<LicenseVO> lList) {
		this.lList = lList;
	}

	@Override
	public String toString() {
		return "LicenseVO [employee_id=" + employee_id + ", license=" + license + ", li_org=" + li_org + ", li_date="
				+ li_date + ", lList=" + lList + "]";
	}

}
