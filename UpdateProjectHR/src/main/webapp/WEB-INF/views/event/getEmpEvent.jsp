<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/resources/include/header.jsp"%>

<div class="content-wrapper">
${getEmpEvent }<br>
${pageCri }<br>
${cri }
	<section class="content">
		<div class="box" style="min-height: 600px;">
			<div class="box-header">
				<h3 class="box-title">경조비 신청 목록</h3>
			</div>

			<form action="" method="get">
				<label for="search">검색 유형:</label>
				<select id="search" name="search">
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

			<table class="table">
				<tbody>
					<tr>
						<th style="width: 10px">#</th>
						<th style="width: 50px">
							경조구분
							<c:if test="${cri.sort ne 'eve_class' }">									
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_class&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_class' and cri.order eq 'ASC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_class&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_class' and cri.order eq 'DESC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_class&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
							</c:if>
						</th>
						<th style="width: 50px">
							대상자명
							<c:if test="${cri.sort ne 'eve_subject' }">									
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_subject&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_subject' and cri.order eq 'ASC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_subject&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_subject' and cri.order eq 'DESC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_subject&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
							</c:if>
						</th>
						<th style="width: 50px">
							경조일자
							<c:if test="${cri.sort ne 'eve_date' }">									
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_date' and cri.order eq 'ASC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_date&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_date' and cri.order eq 'DESC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
							</c:if>
						</th>
						<th style="width: 50px">
							신청일자
							<c:if test="${cri.sort ne 'req_date' }">									
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=req_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'req_date' and cri.order eq 'ASC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=req_date&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'req_date' and cri.order eq 'DESC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=req_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
							</c:if>
						</th>
						<th style="width: 50px">신청금액</th>
						<th style="width: 50px">
							신청상태
							<c:if test="${cri.sort ne 'eve_auth' }">									
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_auth&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_auth' and cri.order eq 'ASC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_auth&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
							</c:if>
							<c:if test="${cri.sort eq 'eve_auth' and cri.order eq 'DESC' }">
								<a href="/event/getEmpEvent?search=${cri.search }&keyword=${cri.keyword }&sort=eve_auth&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
							</c:if>
						</th>
					</tr>

					<c:forEach var="list" items="${getEmpEvent }" varStatus="stat" end="${getEmpEvent.size()}">
						<tr>
							<td>${listEmpEvent.size() - stat.index}</td>
							<td>${list.eve_class }</td>
							<td>${list.eve_subject }</td>
							<td>${list.eve_date }</td>
							<td>${list.req_date }</td>
							<td>${list.eve_amount }</td>
							<td>
								<c:choose>
									<c:when test="${list.eve_auth eq '신청'}">
										<span class="label label-warning">신청</span>
									</c:when>
									<c:when test="${list.eve_auth eq '승인'}">
										<span class="label label-success">승인</span>
									</c:when>
									<c:when test="${list.eve_auth eq '거부'}">
										<span class="label label-danger">거부</span>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</div>

<%@ include file="/resources/include/footer.jsp"%>