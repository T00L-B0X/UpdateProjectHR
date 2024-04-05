<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>BSWILL HRD</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link rel="icon" href="/resources/img/favicon.ico" type="image/x-icon">
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script type="text/javascript" src="header.js"></script>

<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<!-- Logo -->
			<a href="/main" class="logo">
				<!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">HRM</span>
				<!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>BSWILL</b>HRD</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-bell-o"></i> <span class="label label-warning">${countNotification }</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">${countNotification }개의알림이 있습니다.</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<c:forEach var="list" items="${notificationList }">
											<li><a href="${list.noti_link }">
													<i class="fa fa-users text-aqua"></i>${list.noti_title }</a></li>
										</c:forEach>
									</ul>
								</li>
								<li class="footer"><a href="/notification/notificationList">View all</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<img src="/employee/download?PROFIL=${sessionScope.getEmpInfo.PROFIL }" class="user-image" alt="User Image" /> <span class="hidden-xs">${sessionScope.getEmpInfo.emp_name }</span>
							</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img src="/employee/download?PROFIL=${sessionScope.getEmpInfo.PROFIL }" class="img-circle" alt="User Image" />
									<p>
										${sessionScope.getEmpInfo.emp_name } - ${sessionScope.getEmpInfo.DEPTNM } <small>Member since ${sessionScope.getEmpInfo.start_date }</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="/changePassword" class="btn btn-default btn-flat">비밀번호 변경</a>
									</div>
									<div class="pull-right">
										<form action="logoutBswill" method="post" onsubmit="return confirm('로그아웃하시겠습니까?');">
											<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
											<input type="submit" class="btn btn-default btn-flat" value="로그아웃">
										</form>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar">
								<i class="fa fa-gears"></i>
							</a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel" style="height: 80px;">
					<div class="pull-left image">
						<img src="/employee/download?PROFIL=${sessionScope.getEmpInfo.PROFIL }" class="img-circle" alt="User Image" />
					</div>
					<div class="pull-left info">
						<p>${sessionScope.getEmpInfo.emp_name }</p>
						<h6>${sessionScope.getEmpInfo.DEPTNM }&nbsp;&nbsp;&nbsp;${sessionScope.getEmpInfo.JOB }</h6>
						<c:choose>
							<c:when test="${not empty sessionScope.getEmpInfo }">
								<a href="#">
									<i class="fa fa-circle text-success"></i>Online
								</a>
							</c:when>
							<c:otherwise>
								<a href="#">
									<i class="fa fa-circle text-danger"></i>Offline
								</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">NAVIGATION</li>
					<li class="treeview" id="employee"><a href="#">
							<i class="fa fa-user-plus"></i> <span>인사관리</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
						<ul class="treeview-menu">
							<li><a href="/employee/getEmp">
									<i class="fa fa-circle-o"></i>인사정보조회
								</a></li>
							<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
								<li><a href="/employee/registEmp">
										<i class="fa fa-circle-o"></i>인사정보등록
									</a></li>
								<li><a href="/employee/getEmpList">
										<i class="fa fa-circle-o"></i>인사목록조회
									</a></li>
							</sec:authorize>
						</ul></li>
					<li class="treeview" id="organization"><a href="#">
							<i class="fa fa-puzzle-piece"></i> <span>조직관리</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
						<ul class="treeview-menu">
							<li><a href="/organization/getOrgList">
									<i class="fa fa-circle-o"></i>구성원조회
								</a></li>
							<li><a href="/organization/getFavorList">
									<i class="fa fa-circle-o"></i>즐겨찾기
								</a></li>
							<li><a href="/organization/getDeptList">
									<i class="fa fa-circle-o"></i>부서별조회
								</a></li>
						</ul></li>
					<li class="treeview" id="salary"><a href="#">
							<i class="fa fa-won"></i> <span>급여관리</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
						<ul class="treeview-menu">
							<li><a href="/salary/salarySearch">
									<i class="fa fa-circle-o"></i>급여조회
								</a></li>
							<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
								<li><a href="/salary/salaryInfo">
										<i class="fa fa-circle-o"></i>급상여정보
									</a></li>
								<li><a href="/salary/salaryEnter">
										<i class="fa fa-circle-o"></i>급여입력
									</a></li>
								<li><a href="/salary/registAccount">
										<i class="fa fa-circle-o"></i>계좌등록
									</a></li>
							</sec:authorize>
						</ul></li>
					<li class="treeview"><a href="#">
							<i class="fa fa-laptop"></i> <span>경조비관리</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
						<ul class="treeview-menu">
							<li><a href="/event/applyEvent">
									<i class="fa fa-circle-o"></i>경조비신청
								</a></li>
							<li><a href="/event/getEmpEvent">
									<i class="fa fa-circle-o"></i>경조비신청내역
								</a></li>
							<sec:authorize access="hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')">
								<li><a href="/event/getEventList">
										<i class="fa fa-circle-o"></i>경조비신청관리
									</a></li>
							</sec:authorize>
						</ul></li>
					<li class="treeview"><a href="/board/list">
							<i class="fa fa-clipboard"></i> <span>공지사항</span>
						</a></li>
					<li class="/notification/list"><a href="#">
							<i class="fa fa-bell-o"></i> <span>알림목록</span>
						</a></li>
			</section>
		</aside>