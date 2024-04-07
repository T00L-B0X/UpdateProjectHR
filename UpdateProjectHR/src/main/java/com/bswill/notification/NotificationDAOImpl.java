package com.bswill.notification;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bswill.domain.NotificationVO;

@Repository
public class NotificationDAOImpl implements NotificationDAO {

	private static final Logger logger = LoggerFactory.getLogger(NotificationDAOImpl.class);

	private static final String NAMESPACE = "com.bswill.mappers.NotificationMapper";

	@Inject
	private SqlSession sqlsession;

	@Override
	public void insertNoti(NotificationVO nvo) throws Exception {
		logger.debug("insertNoti(Integer employee_id");

		sqlsession.insert(NAMESPACE + ".insertNoti", nvo);
	}

}
