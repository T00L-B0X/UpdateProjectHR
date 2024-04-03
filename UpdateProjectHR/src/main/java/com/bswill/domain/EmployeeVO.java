package com.bswill.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeVO {

	private int employee_id;
	private String PASSWD;
	private String emp_name;
	private String PROFIL;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String birth;
	private int gender;
	private String emp_tel;
	private String emp_mail;
	private String emp_addr;
	private int JOB_ID;
	private int DEPTID;
	private int STATUS;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String start_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String quit_date;
	private String FAVORS;
	private String enabled;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getPASSWD() {
		return PASSWD;
	}

	public void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getPROFIL() {
		return PROFIL;
	}

	public void setPROFIL(String pROFIL) {
		PROFIL = pROFIL;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmp_tel() {
		return emp_tel;
	}

	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}

	public String getEmp_mail() {
		return emp_mail;
	}

	public void setEmp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}

	public String getEmp_addr() {
		return emp_addr;
	}

	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}

	public int getJOB_ID() {
		return JOB_ID;
	}

	public void setJOB_ID(int jOB_ID) {
		JOB_ID = jOB_ID;
	}

	public int getDEPTID() {
		return DEPTID;
	}

	public void setDEPTID(int dEPTID) {
		DEPTID = dEPTID;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getQuit_date() {
		return quit_date;
	}

	public void setQuit_date(String quit_date) {
		this.quit_date = quit_date;
	}

	public String getFAVORS() {
		return FAVORS;
	}

	public void setFAVORS(String fAVORS) {
		FAVORS = fAVORS;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "EmployeeVO [employee_id=" + employee_id + ", PASSWD=" + PASSWD + ", emp_name=" + emp_name + ", PROFIL=" + PROFIL + ", birth=" + birth
				+ ", gender=" + gender + ", emp_tel=" + emp_tel + ", emp_mail=" + emp_mail + ", emp_addr=" + emp_addr + ", JOB_ID=" + JOB_ID
				+ ", DEPTID=" + DEPTID + ", STATUS=" + STATUS + ", start_date=" + start_date + ", quit_date=" + quit_date + ", FAVORS=" + FAVORS
				+ ", enabled=" + enabled + "]";
	}

}
