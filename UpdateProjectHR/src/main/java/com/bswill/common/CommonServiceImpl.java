package com.bswill.common;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

	@Inject
	private CommonDAO cdao;

	@Override
	public String getPasswd(Integer employee_id) throws Exception {
		logger.debug("getPasswd() 호출");

		return cdao.selectPasswd(employee_id);
	}

}
