package com.bswill.event;

import java.util.List;

import com.bswill.domain.Criteria;
import com.bswill.domain.EventVO;

public interface EventService {

	// 경조비 신청
	public void applyEvent(EventVO evo) throws Exception;

	// 로그인한 사원의 경조비 신청 목록수
	public int countEmpEvent(Criteria cri) throws Exception;

	// 로그인한 사원의 경조비 신청 목록
	public List<EventVO> getEmpEvent(Criteria cri) throws Exception;

}
