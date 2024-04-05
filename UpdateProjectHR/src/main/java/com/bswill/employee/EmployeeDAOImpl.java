package com.bswill.employee;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bswill.domain.AppointmentVO;
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

}
