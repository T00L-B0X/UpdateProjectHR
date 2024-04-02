<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/resources/include/header.jsp"%>

<section class="content-header">
	<h1>${message }</h1>
</section>
<section class="content">
	<div class="error-page">
		<h2 class="headline text-red">403</h2>
		<h2 class="text-red" style="text-align: center;">Forbidden</h2>
		<div class="error-content" style="text-align: center;">
			<h3>
				<i class="fa fa-warning text-red"></i>접근권한이 없습니다.
			</h3>
			<h5>관리자에게 문의해주세요.</h5>
			<p>
				MANAGER E-MAIL: manager@gmail.com
				<br>
				MAMAGER TEL: 010-XXXX-XXXX
			</p>
		</div>
	</div>
</section>

<%@ include file="/resources/include/footer.jsp"%>