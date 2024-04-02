package com.bswill.common;

public interface CommonDAO {

	// 사원의 비밀번호 선택
	public String selectPasswd(Integer employee_id) throws Exception;

}
