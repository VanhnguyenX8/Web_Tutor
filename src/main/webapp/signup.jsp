
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng ký tài khoản</title>
<link rel="stylesheet" type="text/css" href="css/signup.css">
</head>
<body>
	<h1>Tạo Tài Khoản của bạn!</h1>
	<p1>Học tập và giao lưu với hàng triệu học viên trên mọi miền đất
	nước!</p1>
	<div class="login">
		<button class="dang_nhap_fb">Đăng ký qua facebook</button>
		<button class="dang_nhap_google">Đăng ký qua Google</button>
		<button class="dang_nhap_yahoo">Đăng ký qua Yahoo</button>
		<button class="dang_nhap_apple">Đăng ký qua Apple</button>
		<h2>Người dùng đăng ký</h2>
		<form action="SignUpServlet" method="post">
			<label for="username">Tài Khoản:</label> <input type="text"
				id="username" name="username" required><br> <label
				for="password">Mật Khẩu:</label> <input type="password"
				id="password" name="password" required><br> <label
				for="renamepass">Nhập lại Mật Khẩu:</label> <input type="password"
				id="password" name="renamepass" required><br> <input
				type="submit" value="Signup">
		</form>
	</div>
</body>
</html>