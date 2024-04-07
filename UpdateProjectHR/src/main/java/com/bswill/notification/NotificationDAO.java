package com.bswill.notification;

import com.bswill.domain.NotificationVO;

public interface NotificationDAO {

	// 알림 등록
	public void insertNoti(NotificationVO nvo) throws Exception;

}
