package com.bswill.event;

import java.util.List;
import java.util.Map;

import com.bswill.domain.Criteria;
import com.bswill.domain.EventVO;

public interface EventDAO {

	// 경조비 신청
	public void insertEvent(EventVO evo) throws Exception;

	// 로그인한 사원의 경조비 신청 목록수
	public int selectEmpEventCount(Criteria cri) throws Exception;

	// 로그인한 사원의 경조비 신청 목록
	public List<EventVO> selectEmpEvent(Criteria cri) throws Exception;

	// 전체 경조비 신청 목록수
	public int selectEventListCount(Criteria cri) throws Exception;

	// 전체 경조비 신청 목록
	public List<EventVO> selectEventList(Criteria cri) throws Exception;

	// 사원 계좌 조회
	public Map<String, Object> selectEmpSalary(int employee_id) throws Exception;

	// 경조비 승인
	public void updateEventAuthApprove(EventVO evo) throws Exception;

	// 경조비 거부
	public void updateEventAuthReject(EventVO evo) throws Exception;

}
