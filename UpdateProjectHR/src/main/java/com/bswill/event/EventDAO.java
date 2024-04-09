package com.bswill.event;

import com.bswill.domain.EventVO;

public interface EventDAO {

	// 경조비 신청
	public void insertEvent(EventVO evo) throws Exception;

}
