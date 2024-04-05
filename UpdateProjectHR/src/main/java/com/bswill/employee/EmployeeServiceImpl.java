package com.bswill.employee;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.LicenseVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Inject
	private EmployeeDAO edao;

	@Override
	public Map<String, Object> getEmpInfo(Integer employee_id) throws Exception {
		logger.debug("getEmpInfo(Integer employee_id) 호출");

		return edao.selectEmpInfo(employee_id);
	}

	@Override
	public List<LicenseVO> getEmpLicense(Integer employee_id) throws Exception {
		logger.debug("getEmpLicense(Integer employee_id) 호출");

		return edao.selectEmpLicense(employee_id);
	}

	@Override
	public List<AppointmentVO> getEmpAppointment(Integer employee_id) throws Exception {
		logger.debug("getEmpAppointment(Integer employee_id) 호출");

		return edao.selectEmpAppointment(employee_id);
	}

}
