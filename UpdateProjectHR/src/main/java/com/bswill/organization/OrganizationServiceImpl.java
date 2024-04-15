package com.bswill.organization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.Criteria;
import com.bswill.domain.DepartmentVO;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

	@Inject
	private OrganizationDAO odao;

	@Override
	public List<Map<String, Object>> getOrgList(Criteria cri) throws Exception {
		logger.debug("getOrgList() 호출");

		return odao.selectOrgList(cri);
	}

	@Override
	public String getEmpFavors(Integer employee_id) throws Exception {
		logger.debug("getEmpFavors(Integer employee_id) 호출");

		return odao.selectEmpFavors(employee_id);
	}

	@Override
	public void modifyFavors(int employee_id, String FAVORS) throws Exception {
		logger.debug("modifyFavors(int employee_id, String FAVORS) 호출");

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("employee_id", employee_id);
		paramMap.put("FAVORS", FAVORS);

		odao.updateFavors(paramMap);
	}

	@Override
	public List<Map<String, Object>> getFavorsList(int employee_id, Criteria cri) throws Exception {
		logger.debug("getFavorsList(int employee_id, Criteria cri) 호출");

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("employee_id", employee_id);
		paramMap.put("cri", cri);

		return odao.selectEmpFavorsList(paramMap);
	}

	@Override
	public List<DepartmentVO> getDeptInfo() throws Exception {
		logger.debug("getDeptInfo() 호출");

		return odao.selectDeptInfo();
	}

	@Override
	public List<Map<String, Object>> getOrgDeptList(int DEPTID, Criteria cri) throws Exception {
		logger.debug("modifyFavors(int employee_id, String FAVORS) 호출");

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("DEPTID", DEPTID);
		paramMap.put("cri", cri);

		return odao.selectOrgDeptList(paramMap);
	}

}
