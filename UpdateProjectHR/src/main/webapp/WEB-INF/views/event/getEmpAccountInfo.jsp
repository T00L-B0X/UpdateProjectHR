<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 정보 조회</title>
<style>
    .container {
        position: relative;
        display: inline-block;
    }
    .close-button {
        position: absolute;
        bottom: 0;
        right: 0;
        margin: 10px;
    }
</style>
</head>
<body>
	<div class="container">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<td style="width: 80px; text-align: center;">사원번호</td>
				<td style="width: 120px;">${getSalary.employee_id }</td>
				<td style="width: 80px; text-align: center;">연락처</td>
				<td style="width: 230px;">${getSalary.emp_tel }</td>
			</tr>
			<tr>
				<td style="text-align: center;">사원명</td>
				<td>${getSalary.emp_name }</td>
				<td style="text-align: center;">이메일</td>
				<td>${getSalary.emp_mail }</td>
			</tr>
			<tr>
				<td style="text-align: center;">부서</td>
				<td>${getSalary.DEPTNM }</td>
				<td style="text-align: center;">성별</td>
	
				<td>
					<c:choose>
						<c:when test="${getSalary.gender eq 1}">남성</c:when>
						<c:when test="${getSalary.gender eq 2}">여성</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;">직급</td>
				<td>${getSalary.JOB }</td>
				<td style="text-align: center;">재직상태</td>
				<td>
					<c:choose>
						<c:when test="${getSalary.STATUS eq 1}">재직</c:when>
						<c:when test="${getSalary.STATUS eq 2}">휴직</c:when>
						<c:when test="${getSalary.STATUS eq 3}">퇴직</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;">은행</td>
				<td>${getSalary.bank }</td>
				<td style="text-align: center;">기본급</td>
				<td><fmt:formatNumber value="${getSalary.salary }" type="currency" currencyCode="KRW"/></td>
			</tr>
			<tr>
				<td style="text-align: center;">예금주</td>
				<td>${getSalary.account_holder }</td>
				<td style="text-align: center;">계좌</td>
				<td>${getSalary.account }</td>
			</tr>
		</table>
	</div>
	<button class="close-button" onclick="closeWindow()">닫기</button>

    <script>
        function closeWindow() {
            window.close();
        }
    </script>
</body>
</html>
