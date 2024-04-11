package com.bswill.event;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bswill.domain.Criteria;
import com.bswill.domain.EventVO;

@Repository
public class EventDAOImpl implements EventDAO {

	private static final Logger logger = LoggerFactory.getLogger(EventDAOImpl.class);

	private static final String NAMESPACE = "com.bswill.mappers.EventMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertEvent(EventVO evo) throws Exception {
		logger.debug("insertEvent(EventVO evo) 호출");

		sqlSession.insert(NAMESPACE + ".insertEvent", evo);
	}

	@Override
	public int selectEmpEventCount(Criteria cri) throws Exception {
		logger.debug("selectEmpEventCount(Criteria cri) 호출");

		return sqlSession.selectOne(NAMESPACE + ".selectEmpEventCount", cri);
	}

	@Override
	public List<EventVO> selectEmpEvent(Criteria cri) {
		logger.debug("selectEmpEvent(Criteria cri) 호출");

		logger.debug("empdao:" + cri);

		return sqlSession.selectList(NAMESPACE + ".selectEmpEvent", cri);
	}

}
