package com.bswill.organization;

import java.util.List;
import java.util.Map;

import com.bswill.domain.Criteria;
import com.bswill.domain.DepartmentVO;

public interface OrganizationService {

	// 구성원 목록 조회
	public List<Map<String, Object>> getOrgList(Criteria cri) throws Exception;

	// 로그인한 사원의 즐겨찾기
	public String getEmpFavors(Integer employee_id) throws Exception;

	// 로그인한 사원 즐겨찾기 수정
	public void modifyFavors(int employee_id, String FAVORS) throws Exception;

	// 로그인한 사원 즐겨찾기 목록
	public List<Map<String, Object>> getFavorsList(int employee_id, Criteria cri) throws Exception;

	// 부서 목록 조회
	public List<DepartmentVO> getDeptInfo() throws Exception;

	// 로그인한 사원 즐겨찾기 목록
	public List<Map<String, Object>> getOrgDeptList(int DEPTID, Criteria cri) throws Exception;

}
