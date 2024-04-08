<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/resources/include/header.jsp"%>

<div class="content-wrapper">
	<section class="content">
		<div class="box" style="min-height: 600px;">
			<div class="box-header">
				<h3 class="box-title">사원 목록 조회</h3>
			</div>

			<form action="" method="get">
				<label for="search">검색 유형:</label> <select id="search" name="search">
					<option value="employee_id"
						<c:if test="${cri.search eq 'employee_id' }">selected</c:if>>사원번호</option>
					<option value="emp_name"
						<c:if test="${cri.search eq 'emp_name' }">selected</c:if>>사원명</option>
					<option value="JOB"
						<c:if test="${cri.search eq 'JOB' }">selected</c:if>>직급</option>
					<option value="DEPTNM"
						<c:if test="${cri.search eq 'DEPTNM' }">selected</c:if>>부서</option>
					<option value="start_date"
						<c:if test="${cri.search eq 'start_date' }">selected</c:if>>입사일</option>
					<option value="STATUS"
						<c:if test="${cri.search eq 'STATUS' }">selected</c:if>>재직상태</option>
				</select>
				<input type="text" id="keyword" name="keyword">
				<input type="hidden" name="sort" value="employee_id">
				<input type="hidden" name="order" value="ASC">
				<input type="hidden" name="page" value="1">
				<button type="submit">검색</button>
			</form>

			<div class="box-body">
				<div class="row">
					<div class="col-sm-12">
						<table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
							<thead>
								<tr role="row">
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Rendering engine: activate to sort column ascending">
										사원번호
										<c:if test="${cri.sort ne 'employee_id' }">									
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=employee_id&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'employee_id' and cri.order eq 'ASC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=employee_id&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'employee_id' and cri.order eq 'DESC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=employee_id&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">
										사원명
										<c:if test="${cri.sort ne 'emp_name' }">									
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=emp_name&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'emp_name' and cri.order eq 'ASC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=emp_name&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'emp_name' and cri.order eq 'DESC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=emp_name&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending">
										직급
										<c:if test="${cri.sort ne 'JOB' }">									
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=JOB&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'JOB' and cri.order eq 'ASC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=JOB&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'JOB' and cri.order eq 'DESC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=JOB&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Engine version: activate to sort column ascending">
										부서
										<c:if test="${cri.sort ne 'DEPTNM' }">									
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=DEPTNM&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'DEPTNM' and cri.order eq 'ASC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=DEPTNM&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'DEPTNM' and cri.order eq 'DESC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=DEPTNM&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending">
										입사일
										<c:if test="${cri.sort ne 'start_date' }">									
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=start_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'start_date' and cri.order eq 'ASC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=start_date&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'start_date' and cri.order eq 'DESC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=start_date&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending">
										재직상태
										<c:if test="${cri.sort ne 'STATUS' }">									
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=STATUS&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'STATUS' and cri.order eq 'ASC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=STATUS&order=DESC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'STATUS' and cri.order eq 'DESC' }">
											<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=STATUS&order=ASC&page=${cri.page }"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${getEmpList }">
									<tr role="row" class="odd">
										<td><a href="/emp/modifyEmp?employee_id=${list.employee_id }">${list.employee_id }</a></td>
										<td>${list.emp_name }</td>
										<td>${list.JOB }</td>
										<td>${list.DEPTNM }</td>
										<td>${list.start_date }</td>
										<td>
										<c:choose>
											<c:when test="${list.STATUS eq 1}">재직</c:when>
											<c:when test="${list.STATUS eq 2}">휴직</c:when>
											<c:otherwise>퇴직</c:otherwise>
										</c:choose>
									</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">사원번호</th>
									<th rowspan="1" colspan="1">사원명</th>
									<th rowspan="1" colspan="1">직급</th>
									<th rowspan="1" colspan="1">부서</th>
									<th rowspan="1" colspan="1">입사일</th>
									<th rowspan="1" colspan="1">재직상태</th>
								</tr>
							</tfoot>
						</table>
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
								<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=${cri.sort }&order=${cri.order }&page=${pageCri.startPage - 1 }" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
							</li>
						</c:if>
						<c:forEach var="i" begin="${pageCri.startPage }" end="${pageCri.endPage }">
							<li class="paginate_button ${pageCri.cri.page == i ? 'active' : '' }">
								<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=${cri.sort }&order=${cri.order }&page=${i }" aria-controls="example2" data-dt-idx="1" tabindex="0">${i }</a>
							</li>
						</c:forEach>
						<c:if test="${pageCri.next }">
							<li class="paginate_button next" id="example2_next">
								<a href="/employee/getEmpList?search=${cri.search }&keyword=${cri.keyword }&sort=${cri.sort }&order=${cri.order }&page=${pageCri.endPage + 1 }" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</section>
</div>

<%@ include file="/resources/include/footer.jsp"%>