<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/resources/include/header.jsp"%>

<div class="content-wrapper">
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">부서 목록</h3>
			</div>

			<div class="box">
				<div class="box-header">
					<h3 class="box-title">부서정보</h3>
				</div>

				<div class="box-body no-padding">
					<table class="table table-striped" style="font-size: 1.2em;">
						<tbody>
							<tr>
								<th style="width: 10px">#</th>
								<th style="text-align: center;">부서번호</th>
								<th style="text-align: center;">부서이름</th>
							</tr>

							<c:forEach var="info" items="${getDeptInfo}" varStatus="stat">
								<tr>
									<td>${stat.count }</td>
									<td style="text-align: center;"><a href="/organization/getOrgDeptList?DEPTID=${info.DEPTID }">${info.DEPTID }</a></td>
									<td style="text-align: center;">${info.DEPTNM }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
</div>

<%@ include file="/resources/include/footer.jsp"%>