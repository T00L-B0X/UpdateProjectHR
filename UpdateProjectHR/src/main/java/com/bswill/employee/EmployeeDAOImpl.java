package com.bswill.employee;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.Criteria;
import com.bswill.domain.EmployeeVO;
import com.bswill.domain.LicenseVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private static final String NAMESPACE = "com.bswill.mappers.EmployeeMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public Map<String, Object> selectEmpInfo(Integer employee_id) {
		logger.debug("selectEmpInfo(Integer employee_id) 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectEmpInfo", employee_id);
	}

	@Override
	public List<LicenseVO> selectEmpLicense(Integer employee_id) {
		logger.debug("selectEmpLicense(Integer employee_id) 호출");

		return sqlSession.selectList(NAMESPACE + ".selectEmpLicense", employee_id);
	}

	@Override
	public List<AppointmentVO> selectEmpAppointment(Integer employee_id) {
		logger.debug("selectEmpAppointment(Integer employee_id) 호출");

		return sqlSession.selectList(NAMESPACE + ".selectEmpAppointment", employee_id);
	}

	@Override
	public int updateEmpTelAndEmail(EmployeeVO evo) throws Exception {
		logger.debug("updateEmpTelAndEmail(EmployeeVO evo) 호출");

		return sqlSession.update(NAMESPACE + ".updateEmpTelAndEmail", evo);
	}

	@Override
	public int selectEmpnoCount(String year) throws Exception {
		logger.debug("selectEmpCount(String year) 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectEmpnoCount", year);
	}

	@Override
	public int insertEmp(EmployeeVO evo) throws Exception {
		logger.debug("insertEmp(EmployeeVO evo) 호출");

		return sqlSession.insert(NAMESPACE + ".insertEmp", evo);
	}

	@Override
	public int insertRole_Member(Integer employee_id) throws Exception {
		logger.debug("insertRole_Member(Integer employee_id) 호출");

		return sqlSession.insert(NAMESPACE + ".insertRole_Member", employee_id);
	}

	@Override
	public void insertLicense(LicenseVO lvo) throws Exception {
		logger.debug("insertLicense(LicenseVO lvo) 호출");

		sqlSession.insert(NAMESPACE + ".insertLicense", lvo);
	}

	@Override
	public void insertAppointment(AppointmentVO avo) throws Exception {
		logger.debug("insertAppointment(AppointmentVO avo) 호출");

		sqlSession.insert(NAMESPACE + ".insertAppointment", avo);
	}

	@Override
	public int selectEmpCount() throws Exception {
		logger.debug("selectEmpCount() 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectEmpCount");
	}

	@Override
	public List<Map<String, Object>> selectEmpList(Criteria cri) throws Exception {
		logger.debug("selectEmpList(Criteria cri) 호출");

		return sqlSession.selectList(NAMESPACE + ".selectEmpList", cri);
	}

	@Override
	public void updateEmp(EmployeeVO evo) throws Exception {
		logger.debug("updateEmp(EmployeeVO evo) 호출");

		sqlSession.update(NAMESPACE + ".updateEmp", evo);
	}

	@Override
	public void deleteLicense(LicenseVO lvo) {
		logger.debug("deleteLicense(LicenseVO lvo) 호출");

		sqlSession.update(NAMESPACE + ".deleteLicense", lvo);
	}

	@Override
	public void deleteAppointment(AppointmentVO avo) {
		logger.debug("deleteAppointment(AppointmentVO avo) 호출");

		sqlSession.update(NAMESPACE + ".deleteAppointment", avo);
	}

}
