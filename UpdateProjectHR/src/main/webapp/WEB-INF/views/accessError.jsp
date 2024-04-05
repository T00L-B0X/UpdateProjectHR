<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/resources/include/header.jsp"%>

<div class="content-wrapper">
	<section class="content-header">
		<h1>${message }</h1>
	</section>
	<section class="content">
		<div class="error-page">
			<h2 class="headline text-red">403</h2>
			<div class="error-content">
				<h3><i class="fa fa-warning text-red"></i>접근권한이 없습니다.</h3>
				<p>지속적으로 문제가 발생한다면 관리자에게 문의해주세요.<br>
				MAMAGER TEL: 010-XXXX-XXXX<br>
				MANAGER E-MAIL: manager@gmail.com</p>
				<button type="button" class="btn btn-default btn-block" onclick="history.back();">돌아가기</button>
				<button type="button" class="btn btn-default btn-block" onclick="location.href='/main';">메인으로</button>
			</div>
		</div>
	</section>
</div>

<%@ include file="/resources/include/footer.jsp"%>