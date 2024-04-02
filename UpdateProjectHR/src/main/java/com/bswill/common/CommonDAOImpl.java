package com.bswill.common;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO {

	private static final Logger logger = LoggerFactory.getLogger(CommonDAOImpl.class);

	private static final String NAMESPACE = "com.bswill.mappers.CommonMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public String selectPasswd(Integer employee_id) throws Exception {
		logger.debug("selectPasswd() 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectPasswd", employee_id);
	}

}
