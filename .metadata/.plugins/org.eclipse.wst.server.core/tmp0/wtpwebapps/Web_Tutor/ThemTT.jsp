<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cập nhập thông tin</title>
 <link rel="stylesheet" type="text/css" href="css/themthongtin.css" />
</head>
<body>
	<div class="container">
        <h2>Cập nhật thông tin cá nhân</h2>
        <form action="AddInfo" method="post">
            <div class="form-group">
                <label for="name">Tên học sinh:</label>
                <input type="text" id="name" name="name" required>
            </div>
             <div class="form-group">
                <label for="ngaySinh">Năm Sinh:</label>ngaySinh
				<input type="date" id="ngaySinh" name="">
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại:</label>
                <input type="tel" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" requDired>
            </div>
            <div class="form-group">
                <label for="gender">Giới tính:</label>
                <select id="gender" name="gender" required>
                    <option value="">-- Chọn giới tính --</option>
                    <option value="male">Nam</option>
                    <option value="female">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ:</label>
                <textarea id="address" name="address" required></textarea>
            </div>
            <div class="form-group">
                <label for="bankAccount">Số tài khoản:</label>
                <input type="text" id="bankAccount" name="bankAccount" required>
            </div>
            <button type="submit">Cập nhật</button>
        </form>
    </div>
</body>
</html>