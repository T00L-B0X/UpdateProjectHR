package com.bswill.event;

import com.bswill.domain.EventVO;

public interface EventService {

	// 경조비 신청
	public void applyEvent(EventVO evo) throws Exception;

}
