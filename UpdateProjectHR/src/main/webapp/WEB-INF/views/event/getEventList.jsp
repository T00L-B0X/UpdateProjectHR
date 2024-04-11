<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/resources/include/header.jsp"%>

<div class="content-wrapper">
	<section class="content">
		<div class="box" style="min-height: 600px;">
			<div class="box-header">
				<h3 class="box-title">경조비 신청 관리</h3>
			</div>

			<form action="" method="get">
				<label for="search">검색 유형:</label>
				<select id="search" name="search">
					<option value="employee_id" <c:if test="${cri.search eq 'employee_id' }">selected</c:if>>사원번호</option>
					<option value="eve_class" <c:if test="${cri.search eq 'eve_class' }">selected</c:if>>경조구분</option>
					<option value="eve_subject" <c:if test="${cri.search eq 'eve_subject' }">selected</c:if>>대상자명</option>
					<option value="eve_date" <c:if test="${cri.search eq 'eve_date' }">selected</c:if>>경조일자</option>
					<option value="req_date" <c:if test="${cri.search eq 'req_date' }">selected</c:if>>신청일자</option>
					<option value="eve_auth" <c:if test="${cri.search eq 'eve_auth' }">selected</c:if>>신청상태</option>
				</select>
				<input type="text" id="keyword" name="keyword">
				<input type="hidden" name="sort" value="req_date">
				<input type="hidden" name="order" value="DESC">
				<input type="hidden" name="page" value="1">
				<button type="submit">검색</button>
			</form>

			<div class="box-body">
				<div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
					<div class="row">
						<div class="col-sm-12">
							<table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
								<thead>
									<tr role="row">
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" style="width: 10px">#</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">
											사원번호
											<c:if test="${cri.sort ne 'employee_id' }">									
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=employee_id&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'employee_id' and cri.order eq 'ASC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=employee_id&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'employee_id' and cri.order eq 'DESC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=employee_id&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
											</c:if>
										</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">
											경조구분
											<c:if test="${cri.sort ne 'eve_class' }">									
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_class&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_class' and cri.order eq 'ASC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_class&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_class' and cri.order eq 'DESC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_class&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
											</c:if>
										</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">
											대상자명
											<c:if test="${cri.sort ne 'eve_subject' }">									
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_subject&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_subject' and cri.order eq 'ASC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_subject&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_subject' and cri.order eq 'DESC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_subject&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
											</c:if>
										</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">
											경조일자
											<c:if test="${cri.sort ne 'eve_date' }">									
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_date' and cri.order eq 'ASC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_date&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_date' and cri.order eq 'DESC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
											</c:if>
										</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">
											신청일자
											<c:if test="${cri.sort ne 'req_date' }">									
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=req_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'req_date' and cri.order eq 'ASC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=req_date&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'req_date' and cri.order eq 'DESC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=req_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
											</c:if>
										</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">신청금액</th>
										<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1">
											신청상태
											<c:if test="${cri.sort ne 'eve_auth' }">									
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_auth&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_auth' and cri.order eq 'ASC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_auth&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
											</c:if>
											<c:if test="${cri.sort eq 'eve_auth' and cri.order eq 'DESC' }">
												<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=eve_auth&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
											</c:if>
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${getEventList }" varStatus="stat" end="${getEventList.size()}">
										<tr role="row" class="odd">
											<td>${getEventList.size() - stat.index}</td>
											<td>
												<a onclick="openSmallPopup('/event/getEmpAccountInfo?employee_id=${list.employee_id}')" target="_blank">${list.employee_id}</a>
											</td>
											<td>${list.eve_class }</td>
											<td>${list.eve_subject }</td>
											<td>${list.eve_date }</td>
											<td>${list.req_date }</td>
											<td><fmt:formatNumber value="${list.eve_amount}" type="currency" currencyCode="KRW"/></td>
											<td>
												<c:choose>
													<c:when test="${list.eve_auth eq '신청'}">
														<form method="post">
															<input type="hidden" id="employee_id" name="employee_id" value="${list.employee_id}">
															<input type="hidden" id="eve_class" name="eve_class" value="${list.eve_class }">
															<input type="hidden" id="eve_subject" name="eve_subject" value="${list.eve_subject }">
															<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
															<div class="btn-group">
																<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">신청</button>
																<ul class="dropdown-menu" role="menu">
																	<li>
																		<c:url var="approveUrl" value="/event/approveEmpEvent" />
																		<button type="submit" formaction="${approveUrl}" class="btn btn-block btn-success btn-flat">승인</button>
																	</li>
																	<li class="divider"></li>
																	<li>
																		<c:url var="rejectUrl" value="/event/rejectEmpEvent" />
																		<button type="submit" formaction="${rejectUrl}" class="btn btn-block btn-danger btn-flat">거부</button>
																	</li>
																</ul>
															</div>
														</form>
													</c:when>
													<c:when test="${list.eve_auth eq '승인'}">
														<button type="button" class="btn btn-success" style="pointer-events: none;">승인</button>
													</c:when>
													<c:when test="${list.eve_auth eq '거부'}">
														<button type="button" class="btn btn-danger" style="pointer-events: none;">거부</button>
													</c:when>
												</c:choose>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<th rowspan="1" colspan="1">#</th>
										<th rowspan="1" colspan="1">사원번호</th>
										<th rowspan="1" colspan="1">경조구분</th>
										<th rowspan="1" colspan="1">대상자명</th>
										<th rowspan="1" colspan="1">경조일자</th>
										<th rowspan="1" colspan="1">신청일자</th>
										<th rowspan="1" colspan="1">신청금액</th>
										<th rowspan="1" colspan="1">신청상태</th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="dataTables_info" id="example2_info" role="status" aria-live="polite">Showing ${pageCri.startPage } to ${pageCri.endPage } of ${pageCri.total } entries</div>
			</div>
			<div class="col-sm-7">
				<div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
					<ul class="pagination">
						<c:if test="${pageCri.prev }">
							<li class="paginate_button previous disabled" id="example2_previous">
								<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=${cri.sort }&order=${cri.order }&page=${pageCri.startPage - 1 }" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
							</li>
						</c:if>
						<c:forEach var="i" begin="${pageCri.startPage }" end="${pageCri.endPage }">
							<li class="paginate_button ${pageCri.cri.page == i ? 'active' : '' }">
								<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=${cri.sort }&order=${cri.order }&page=${i }" aria-controls="example2" data-dt-idx="1" tabindex="0">${i }</a>
							</li>
						</c:forEach>
						<c:if test="${pageCri.next }">
							<li class="paginate_button next" id="example2_next">
								<a href="/event/getEventList?search=${cri.search }&keyword=${cri.keyword }&sort=${cri.sort }&order=${cri.order }&page=${pageCri.endPage + 1 }" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</section>
</div>

<script>
	function openSmallPopup(url) {
		const width = 500;
		const height = 200;
		const left = (window.screen.width - width) / 2;
		const top = (window.screen.height - height) / 2;
		const options = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top;
		
		window.open(url, 'popup', options);
	}
</script>

<%@ include file="/resources/include/footer.jsp"%>