package com.bswill.organization;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bswill.domain.Criteria;
import com.bswill.domain.DepartmentVO;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationDAOImpl.class);

	private static final String NAMESPACE = "com.bswill.mappers.OrganizationMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<Map<String, Object>> selectOrgList(Criteria cri) throws Exception {
		logger.debug("selectOrgList(Criteria cri) 호출");

		return sqlSession.selectList(NAMESPACE + ".selectOrgList", cri);
	}

	@Override
	public String selectEmpFavors(Integer employee_id) throws Exception {
		logger.debug("selectEmpFavors(Integer employee_id) 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectEmpFavors", employee_id);
	}

	@Override
	public void updateFavors(Map<String, Object> paramMap) throws Exception {
		logger.debug("updateFavors(Map<String, Object> paramMap) 호출");

		sqlSession.update(NAMESPACE + ".updateFavors", paramMap);
	}

	@Override
	public List<Map<String, Object>> selectEmpFavorsList(Map<String, Object> paramMap) throws Exception {
		logger.debug("selectEmpFavorsList(Map<String, Object> paramMap) 호출");

		return sqlSession.selectList(NAMESPACE + ".selectEmpFavorsList", paramMap);
	}

	@Override
	public List<DepartmentVO> selectDeptInfo() throws Exception {
		logger.debug("selectDeptInfo() 호출");

		return sqlSession.selectList(NAMESPACE + ".selectDeptInfo");
	}

	@Override
	public List<Map<String, Object>> selectOrgDeptList(Map<String, Object> paramMap) throws Exception {
		logger.debug("selectOrgDeptList(Map<String, Object> paramMap) 호출");

		return sqlSession.selectList(NAMESPACE + ".selectOrgDeptList", paramMap);
	}

}
