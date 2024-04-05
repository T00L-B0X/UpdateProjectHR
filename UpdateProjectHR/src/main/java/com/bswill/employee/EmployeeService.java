package com.bswill.employee;

import java.util.List;
import java.util.Map;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.LicenseVO;

public interface EmployeeService {

	// 로그인한 사원 정보
	public Map<String, Object> getEmpInfo(Integer employee_id) throws Exception;

	// 로그인한 사원 자격증 정보
	public List<LicenseVO> getEmpLicense(Integer employee_id) throws Exception;

	// 로그인한 사원 발령 정보
	public List<AppointmentVO> getEmpAppointment(Integer employee_id) throws Exception;

}
