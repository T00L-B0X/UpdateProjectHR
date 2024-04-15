package com.bswill.organization;

import java.util.List;
import java.util.Map;

import com.bswill.domain.Criteria;
import com.bswill.domain.DepartmentVO;

public interface OrganizationDAO {

	// 구성원 목록 조회
	public List<Map<String, Object>> selectOrgList(Criteria cri) throws Exception;

	// 로그인한 사원의 즐겨찾기
	public String selectEmpFavors(Integer employee_id) throws Exception;

	// 로그인한 사원 즐겨찾기 수정
	public void updateFavors(Map<String, Object> paramMap) throws Exception;

	// 로그인한 사원의 즐겨찾기 목록
	public List<Map<String, Object>> selectEmpFavorsList(Map<String, Object> paramMap) throws Exception;

	// 부서 목록 조회
	public List<DepartmentVO> selectDeptInfo() throws Exception;

	// 로그인한 사원의 즐겨찾기 목록
	public List<Map<String, Object>> selectOrgDeptList(Map<String, Object> paramMap) throws Exception;

}
