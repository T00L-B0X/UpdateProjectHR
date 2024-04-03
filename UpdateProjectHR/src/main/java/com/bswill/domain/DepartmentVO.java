package com.bswill.domain;

public class DepartmentVO {

	private int DEPTID;
	private String DEPTNM;

	public int getDEPTID() {
		return DEPTID;
	}

	public void setDEPTID(int dEPTID) {
		DEPTID = dEPTID;
	}

	public String getDEPTNM() {
		return DEPTNM;
	}

	public void setDEPTNM(String dEPTNM) {
		DEPTNM = dEPTNM;
	}

	@Override
	public String toString() {
		return "DepartmentVO [DEPTID=" + DEPTID + ", DEPTNM=" + DEPTNM + "]";
	}

}
