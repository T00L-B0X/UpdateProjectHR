package com.bswill.notification;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.NotificationVO;

@Service
public class NotificationServiceImpl implements NotificationService {

	private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Inject
	private NotificationDAO ndao;

	@Override
	public void addNoti(NotificationVO nvo) throws Exception {
		logger.debug("addNoti(Integer employee_id");

		ndao.insertNoti(nvo);
	}

}
