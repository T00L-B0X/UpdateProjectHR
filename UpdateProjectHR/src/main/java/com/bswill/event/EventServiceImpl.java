package com.bswill.event;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bswill.domain.Criteria;
import com.bswill.domain.EventVO;
import com.bswill.domain.NotificationVO;
import com.bswill.notification.NotificationService;

@Service
public class EventServiceImpl implements EventService {

	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

	@Inject
	private EventDAO edao;

	@Inject
	private NotificationService notiService;

	@Override
	public void applyEvent(EventVO evo) throws Exception {
		logger.debug("applyEvent(EventVO evo) 호출");

		edao.insertEvent(evo);
	}

	@Override
	public int countEmpEvent(Criteria cri) throws Exception {
		logger.debug("countEmpEvent(Criteria cri) 호출");

		return edao.selectEmpEventCount(cri);
	}

	@Override
	public List<EventVO> getEmpEvent(Criteria cri) throws Exception {
		logger.debug("getEmpEvent(Criteria cri) 호출");

		return edao.selectEmpEvent(cri);
	}

	@Override
	public int countEventList(Criteria cri) throws Exception {
		logger.debug("countEventList(Criteria cri) 호출");

		return edao.selectEventListCount(cri);
	}

	@Override
	public List<EventVO> getEventList(Criteria cri) throws Exception {
		logger.debug("getEventList(Criteria cri) 호출");

		return edao.selectEventList(cri);
	}

	@Override
	public Map<String, Object> getEmpSalary(int employee_id) throws Exception {
		logger.debug("getEmpSalary(int employee_id) 호출");

		return edao.selectEmpSalary(employee_id);
	}

	@Override
	public void modifyEventAuthApprove(EventVO evo) throws Exception {
		logger.debug("modifyEventAuthApprove(EventVO evo) 호출");

		edao.updateEventAuthApprove(evo);

		NotificationVO nvo = new NotificationVO();
		nvo.setEmployee_id(evo.getEmployee_id());
		nvo.setNoti_title("요청하신 " + evo.getEve_subject() + "씨의 " + evo.getEve_class() + " 경조비 신청이 승인되었습니다.");
		nvo.setNoti_link("/event/getEmpEvent?search=eve_auth&keyword=%EC%8A%B9%EC%9D%B8");

		notiService.addNoti(nvo);
	}

	@Override
	public void modifyEventAuthReject(EventVO evo) throws Exception {
		logger.debug("modifyEventAuthReject(EventVO evo) 호출");

		edao.updateEventAuthReject(evo);

		NotificationVO nvo = new NotificationVO();
		nvo.setEmployee_id(evo.getEmployee_id());
		nvo.setNoti_title("요청하신 " + evo.getEve_subject() + "씨의 " + evo.getEve_class() + " 경조비 신청이 거부되었습니다.");
		nvo.setNoti_link("/event/getEmpEvent?search=eve_auth&keyword=%EA%B1%B0%EB%B6%80");

		notiService.addNoti(nvo);
	}

}
