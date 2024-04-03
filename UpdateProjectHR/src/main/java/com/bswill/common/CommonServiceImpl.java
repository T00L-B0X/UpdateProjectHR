package com.bswill.common;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.DepartmentVO;
import com.bswill.domain.JobVO;

@Service
public class CommonServiceImpl implements CommonService {

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

	@Inject
	private CommonDAO cdao;

	@Override
	public Map<String, Object> getEmpInfo(Integer employee_id) throws Exception {
		logger.debug("getEmpInfo() 호출");

		return cdao.selectEmpInfo(employee_id);
	}

	@Override
	public List<JobVO> getJobInfo() throws Exception {
		logger.debug("getJobInfo() 호출");

		return cdao.selectJobInfo();
	}

	@Override
	public List<DepartmentVO> getDeptInfo() throws Exception {
		logger.debug("getDeptInfo() 호출");

		return cdao.selectDeptInfo();
	}

	@Override
	public String getPassword(Integer employee_id) throws Exception {
		logger.debug("getPassword(Integer employee_id) 호출");

		return cdao.selectPassword(employee_id);
	}

	@Override
	public void modifyPassword(Integer employee_id, String newPassword) throws Exception {
		logger.debug("modifyPassword(Integer employee_id, String password) 호출");

		cdao.updatePassword(employee_id, newPassword);
	}

}
