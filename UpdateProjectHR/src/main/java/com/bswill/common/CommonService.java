package com.bswill.common;

import java.util.List;
import java.util.Map;

import com.bswill.domain.DepartmentVO;
import com.bswill.domain.JobVO;

public interface CommonService {

	// 로그인한 사원 정보 조회
	public Map<String, Object> getEmpInfo(Integer employee_id) throws Exception;

	// 직책 목록 조회
	public List<JobVO> getJobInfo() throws Exception;

	// 부서 목록 조회
	public List<DepartmentVO> getDeptInfo() throws Exception;

	// 사원 비밀번호 선택
	public String getPassword(Integer employee_id) throws Exception;

	// 사원 비밀번호 변경
	public void modifyPassword(Integer employee_id, String newPassword) throws Exception;

	// 전체 사원수 조회
	public int getEmpCount() throws Exception;

	// 재직 사원수 조회
	public int getCurrentEmpCount() throws Exception;

	// 올해 입사자수 조회
	public int getNewEmpCount() throws Exception;

}
