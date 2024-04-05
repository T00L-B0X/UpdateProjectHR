<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="/resources/img/favicon.ico" type="image/x-icon">
<title>BSWILL HRD | 비밀번호 변경</title>

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
<script src="/resources/js/changePassword.js"></script>

</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#">
				<b>BSWILL</b>
			</a>
		</div>

		<div class="login-box-body">
			<p class="login-box-msg">비밀번호 변경</p>
			<form action="" method="post">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
				<div class="form-group has-feedback">
					<label for="currentPassword">현재 비밀번호 </label>
					<input class="form-control" maxlength='16' type="password" id="currentPassword" name="currentPassword" placeholder="영문/숫자 최대 8-16자" required>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<br>
				</div>
				<div class="form-group has-feedback">
					<label for="newPassword">새로운 비밀번호 </label>
					<input class="form-control" maxlength='16' type="password" id="newPassword" name="newPassword" placeholder="영문/숫자 최대 8-16자" required>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<br>
				</div>
				<div class="form-group has-feedback">
					<label for="confirmNewPassword">새로운 비밀번호 확인 </label>
					<input class="form-control" maxlength='16' type="password" id="confirmPassword" name="confirmPassword" placeholder="영문/숫자 최대 8-16자" required>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<br>
				</div>
				<p>${error }</p>
				<div class="button-container">
					<div class="row">
						<div class="col-xs-6">
							<button id="submitBtn" type="submit" class="btn btn-primary btn-block btn-flat">변경하기</button>
						</div>
						<div class="col-xs-6">
							<button class="btn btn-primary btn-block btn-flat" onclick="location.href='/main'">메인으로</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>