package com.bswill.employee;

import java.util.List;
import java.util.Map;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.Criteria;
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
	public int selectEmpnoCount(String year) throws Exception;

	// 사원 등록
	public int insertEmp(EmployeeVO evo) throws Exception;

	// 사원(MEMBER) 권한 등록
	public int insertRole_Member(Integer employee_id) throws Exception;

	// 사원 자격증 등록
	public void insertLicense(LicenseVO lvo) throws Exception;

	// 사원 발령정보 등록
	public void insertAppointment(AppointmentVO avo) throws Exception;

	// DB에 등록된 사원수
	public int selectEmpCount() throws Exception;

	// 사원 목록(페이징)
	public List<Map<String, Object>> selectEmpList(Criteria cri) throws Exception;

	// 사원 정보 수정
	public void updateEmp(EmployeeVO evo) throws Exception;

	// 자격증 정보 삭제
	public void deleteLicense(LicenseVO lvo);

	// 발령 정보 삭제
	public void deleteAppointment(AppointmentVO avo);

}
