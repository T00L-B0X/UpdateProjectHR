package com.bswill.domain;

import java.sql.Timestamp;

public class BoardVO {

	private int board_no;
	private String title;
	private int employee_id;
	private String content;
	private Timestamp regdate;
	private Timestamp updatedate;
	private int readcnt;

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", title=" + title + ", employee_id=" + employee_id + ", content="
				+ content + ", regdate=" + regdate + ", updatedate=" + updatedate + ", readcnt=" + readcnt + "]";
	}

}
