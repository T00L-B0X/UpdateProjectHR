package com.bswill.employee;

import java.util.List;
import java.util.Map;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.EmployeeVO;
import com.bswill.domain.LicenseVO;

public interface EmployeeDAO {

	// 로그인한 사원 정보
	public Map<String, Object> selectEmpInfo(Integer employee_id) throws Exception;

	// 로그인한 사원 자격증 정보
	public List<LicenseVO> selectEmpLicense(Integer employee_id) throws Exception;

	// 로그인한 사원 발령 정보
	public List<AppointmentVO> selectEmpAppointment(Integer employee_id) throws Exception;

	// 로그인한 사원 연락처, 이메일 수정
	public int updateEmpTelAndEmail(EmployeeVO evo) throws Exception;

	// 사원번호용 사원수
	public int selectEmpCount(String year) throws Exception;

	// 사원 등록
	public int insertEmp(EmployeeVO evo) throws Exception;

	// 사원(MEMBER) 권한 등록
	public int insertRole_Member(Integer employee_id) throws Exception;

	// 사원 자격증 등록
	public void insertLicense(LicenseVO lvo) throws Exception;

	// 사원 발령정보 등록
	public void insertAppointment(AppointmentVO avo) throws Exception;

}
