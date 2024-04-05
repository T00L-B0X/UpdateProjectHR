package com.bswill.employee;

import java.util.List;
import java.util.Map;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.LicenseVO;

public interface EmployeeDAO {

	// 로그인한 사원 정보
	public Map<String, Object> selectEmpInfo(Integer employee_id);

	// 로그인한 사원 자격증 정보
	public List<LicenseVO> selectEmpLicense(Integer employee_id);

	// 로그인한 사원 발령 정보
	public List<AppointmentVO> selectEmpAppointment(Integer employee_id);

}
