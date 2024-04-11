package com.bswill.event;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.Criteria;
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

	@Override
	public int countEmpEvent(Criteria cri) throws Exception {
		logger.debug("countEmpEvent() 호출");

		return edao.selectEmpEventCount(cri);
	}

	@Override
	public List<EventVO> getEmpEvent(Criteria cri) throws Exception {
		logger.debug("getEmpEvent(Criteria cri) 호출");

		logger.debug("empserv:" + cri.getEmployee_id());

		return edao.selectEmpEvent(cri);
	}

}
