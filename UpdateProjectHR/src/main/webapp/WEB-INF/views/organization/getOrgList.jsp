<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/resources/include/header.jsp"%>

<div class="content-wrapper">
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">구성원 목록</h3>
			</div>
			
			<form action="/organization/updateFavors" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				
				<div class="box-body">
				<div class="row">
					<div class="col-sm-12">
						<button type="submit" onclick="alert('즐겨찾기 변경');" style="margin-bottom: 20px">즐겨찾기 변경</button>
						<table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
							<thead>
								<tr role="row">
									<th><input type="checkbox" onclick="toggleAll(this)"></th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Rendering engine: activate to sort column ascending">
										사원번호
										<c:if test="${cri.sort ne 'employee_id' }">									
											<a href="/organization/getOrgList?sort=employee_id&order=ASC"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'employee_id' and cri.order eq 'ASC' }">
											<a href="/organization/getOrgList?sort=employee_id&order=DESC"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'employee_id' and cri.order eq 'DESC' }">
											<a href="/organization/getOrgList?sort=employee_id&order=ASC"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending">
										사원명
										<c:if test="${cri.sort ne 'emp_name' }">									
											<a href="/organization/getOrgList?sort=emp_name&order=ASC"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'emp_name' and cri.order eq 'ASC' }">
											<a href="/organization/getOrgList?sort=emp_name&order=DESC"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'emp_name' and cri.order eq 'DESC' }">
											<a href="/organization/getOrgList?sort=emp_name&order=ASC"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Engine version: activate to sort column ascending">
										부서
										<c:if test="${cri.sort ne 'DEPTNM' }">									
											<a href="/organization/getOrgList?sort=DEPTNM&order=ASC"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'DEPTNM' and cri.order eq 'ASC' }">
											<a href="/organization/getOrgList?sort=DEPTNM&order=DESC"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'DEPTNM' and cri.order eq 'DESC' }">
											<a href="/organization/getOrgList?sort=DEPTNM&order=ASC"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending">
										직급
										<c:if test="${cri.sort ne 'JOB' }">									
											<a href="/organization/getOrgList?sort=JOB&order=ASC"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'JOB' and cri.order eq 'ASC' }">
											<a href="/organization/getOrgList?sort=JOB&order=DESC"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'JOB' and cri.order eq 'DESC' }">
											<a href="/organization/getOrgList?sort=JOB&order=ASC"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending">연락처</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending">이메일</th>
									<th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending">
										재직상태
										<c:if test="${cri.sort ne 'STATUS' }">									
											<a href="/organization/getOrgList?sort=STATUS&order=ASC"><span class="glyphicon glyphicon-sort"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'STATUS' and cri.order eq 'ASC' }">
											<a href="/organization/getOrgList?sort=STATUS&order=DESC"><span class="glyphicon glyphicon-sort-by-attributes"></span></a>
										</c:if>
										<c:if test="${cri.sort eq 'STATUS' and cri.order eq 'DESC' }">
											<a href="/organization/getOrgList?sort=STATUS&order=ASC"><span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a>
										</c:if>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${getOrgList }">
									<tr role="row" class="odd">
										<td><input type="checkbox" name="favors" value="${list.employee_id}" <c:if test="${fn:indexOf(getEmpFavors, list.employee_id) ne -1 }">checked</c:if>></td>
										<td>${list.employee_id }</td>
										<td>${list.emp_name }</td>
										<td>${list.DEPTNM }</td>
										<td>${list.JOB }</td>
										<td>${list.emp_tel }</td>
										<td>${list.emp_mail }</td>
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
									<th><input type="checkbox" onclick="toggleAll(this)"></th>
									<th rowspan="1" colspan="1">사원번호</th>
									<th rowspan="1" colspan="1">사원명</th>
									<th rowspan="1" colspan="1">부서</th>
									<th rowspan="1" colspan="1">직급</th>
									<th rowspan="1" colspan="1">연락처</th>
									<th rowspan="1" colspan="1">이메일</th>									
									<th rowspan="1" colspan="1">재직상태</th>
								</tr>
							</tfoot>
						</table>
						<button type="submit" onclick="alert('즐겨찾기 변경');">즐겨찾기 변경</button>
					</div>
				</div>
			</div>
			</form>
		</div>
	</section>
</div>

<script>
	function toggleAll(source) {
		checkboxes = document.getElementsByName('favors');
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = source.checked;
		}
	}
</script>

<%@ include file="/resources/include/footer.jsp"%>