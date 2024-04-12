package com.bswill.organization;

import java.util.List;
import java.util.Map;

import com.bswill.domain.Criteria;

public interface OrganizationDAO {

	// 구성원 목록 조회
	public List<Map<String, Object>> selectOrgList(Criteria cri) throws Exception;

	// 로그인한 사원의 즐겨찾기
	public String selectEmpFavors(Integer employee_id) throws Exception;

	// 로그인한 사원 즐겨찾기 수정
	public void updateFavors(Map<String, Object> paramMap) throws Exception;

}
