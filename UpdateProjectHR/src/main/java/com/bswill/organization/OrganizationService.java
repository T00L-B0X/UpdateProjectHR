package com.bswill.organization;

import java.util.List;
import java.util.Map;

import com.bswill.domain.Criteria;

public interface OrganizationService {

	// 구성원 목록 조회
	public List<Map<String, Object>> getOrgList(Criteria cri) throws Exception;

	// 로그인한 사원의 즐겨찾기
	public String getEmpFavors(Integer employee_id) throws Exception;

	// 로그인한 사원 즐겨찾기 수정
	public void modifyFavors(int employee_id, String FAVORS) throws Exception;

}
