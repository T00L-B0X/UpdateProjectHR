package com.bswill.notification;

import com.bswill.domain.NotificationVO;

public interface NotificationService {

	// 알림 등록
	public void addNoti(NotificationVO nvo) throws Exception;

}
