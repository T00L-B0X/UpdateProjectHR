package com.bswill.employee;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.Criteria;
import com.bswill.domain.EmployeeVO;
import com.bswill.domain.LicenseVO;

public interface EmployeeService {

	// 로그인한 사원 정보
	public Map<String, Object> getEmpInfo(Integer employee_id) throws Exception;

	// 로그인한 사원 자격증 정보
	public List<LicenseVO> getEmpLicense(Integer employee_id) throws Exception;

	// 로그인한 사원 발령 정보
	public List<AppointmentVO> getEmpAppointment(Integer employee_id) throws Exception;

	// 로그인한 사원 연락처, 이메일 수정
	public int modifyEmpTelAndEmail(EmployeeVO evo) throws Exception;

	// 사원 등록
	public void registEmp(EmployeeVO evo, MultipartFile profile, LicenseVO lList, AppointmentVO aList,
			HttpServletRequest req) throws Exception;

	// DB에 등록된 사원수
	public int countEmp() throws Exception;

	// 사원 목록
	public List<Map<String, Object>> getEmpList(Criteria cri) throws Exception;

	// 사원 정보 수정
	public void modifyEmp(EmployeeVO evo, MultipartFile profile, HttpServletRequest req) throws Exception;

	// 자격증 정보 추가
	public void addEmpLicense(LicenseVO lvo) throws Exception;

	// 자격증 정보 삭제
	public void subEmpLicense(LicenseVO lvo) throws Exception;

	// 발령 정보 추가
	public void addEmpAppointment(AppointmentVO avo) throws Exception;

	// 발령 정보 삭제
	public void subEmpAppointment(AppointmentVO avo) throws Exception;

}
