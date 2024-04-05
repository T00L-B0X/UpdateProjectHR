<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="/resources/img/favicon.ico" type="image/x-icon">
<title>BSWILL HRD | Log in</title>

<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
<link rel="stylesheet" href="/resources/bootstrap/dist/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#">
				<b>BSWILL</b>
			</a>
		</div>

		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start BSWILL HRD</p>
			<form action="/login" method="post">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="username" placeholder="사원번호">
					<span class="glyphicon glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password" placeholder="비밀번호">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<p style="text-align: center;">${error }${logout }</p>
				<div class="row">
					<div class="col-xs-4 col-xs-offset-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Login</button>
					</div>
				</div>
			</form>
			
			<hr>
			
			<a>지속적으로 문제가 발생한다면?</a><br>
			<a href="tel:010-XXXX-XXXX">Manager tel: 010-XXXX-XXXX</a><br>
			<a href="mailto:manager@gmail.com" class="text-center">Manager E-mail: manager@gmail.com</a>
		</div>
	</div>
</body>
</html>