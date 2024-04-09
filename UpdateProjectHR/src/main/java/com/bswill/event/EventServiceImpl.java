package com.bswill.event;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.EventVO;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

	@Inject
	private EventDAO edao;

	@Override
	public void applyEvent(EventVO evo) throws Exception {
		logger.debug("applyEvent(EventVO evo) 호출");

		edao.insertEvent(evo);
	}

}
