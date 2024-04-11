package com.bswill.event;

import java.util.List;
import java.util.Map;

import com.bswill.domain.Criteria;
import com.bswill.domain.EventVO;

public interface EventService {

	// 경조비 신청
	public void applyEvent(EventVO evo) throws Exception;

	// 로그인한 사원의 경조비 신청 목록수
	public int countEmpEvent(Criteria cri) throws Exception;

	// 로그인한 사원의 경조비 신청 목록
	public List<EventVO> getEmpEvent(Criteria cri) throws Exception;

	// 전체 경조비 신청 목록수
	public int countEventList(Criteria cri) throws Exception;

	// 전체 경조비 신청 목록
	public List<EventVO> getEventList(Criteria cri) throws Exception;

	// 사원 계좌 조회
	public Map<String, Object> getEmpSalary(int employee_id) throws Exception;

	// 경조비 승인
	public void modifyEventAuthApprove(EventVO evo) throws Exception;

	// 경조비 거부
	public void modifyEventAuthReject(EventVO evo) throws Exception;

}
