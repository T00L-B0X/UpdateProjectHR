package com.bswill.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bswill.domain.DepartmentVO;
import com.bswill.domain.JobVO;

@Repository
public class CommonDAOImpl implements CommonDAO {

	private static final Logger logger = LoggerFactory.getLogger(CommonDAOImpl.class);

	private static final String NAMESPACE = "com.bswill.mappers.CommonMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public Map<String, Object> selectEmpInfo(Integer employee_id) {
		logger.debug("selectEmpInfo(Integer employee_id) 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectEmpInfo", employee_id);
	}

	@Override
	public List<JobVO> selectJobInfo() throws Exception {
		logger.debug("selectJobInfo() 호출");

		return sqlSession.selectList(NAMESPACE + ".selectJobInfo");
	}

	@Override
	public List<DepartmentVO> selectDeptInfo() {
		logger.debug("selectDeptInfo() 호출");

		return sqlSession.selectList(NAMESPACE + ".selectDeptInfo");
	}

	@Override
	public String selectPassword(Integer employee_id) throws Exception {
		logger.debug("selectPassword(Integer employee_id) 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectPasswd", employee_id);
	}

	@Override
	public void updatePassword(Integer employee_id, String newPassword) throws Exception {
		logger.debug("updatePassword(Integer employee_id, String password) 호출");

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("employee_id", employee_id);
		paramMap.put("newPassword", newPassword);

		sqlSession.update(NAMESPACE + ".updatePasswd", paramMap);

	}

}
