<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhập thông tin</title>
 <link rel="stylesheet" type="text/css" href="css/themthongtin.css" />
</head>
<body>
	<div class="container">
        <h2>Cập nhật thông tin cá nhân</h2>
        <form action="AddInfo" method="post" >
            <div class="form-group">
                <label for="name">Họ Và Tên:</label>
                <input type="text" id="name" name="name" value="<%= request.getAttribute("ten") %>" required>
            </div>
             <div class="form-group">
                <label for="ngaySinh">Năm Sinh:</label>
				<input type="date" id="ngaySinh" name="ngaySinh" value="<%= request.getAttribute("ngaySinh") %>">
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại:</label>
                <input type="tel" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= request.getAttribute("soDienThoai") %>" requDired>
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
                <textarea id="address" name="address" value="<%= request.getAttribute("diaChi") %>" value="<%= request.getAttribute("soDienThoai") %>" required></textarea>
            </div>
            <div class="form-group">
                <label for="bankAccount">Số tài khoản:</label>
                <input type="text" id="bankAccount" name="bankAccount" value="<%= request.getAttribute("stk") %>" required>
            </div>
            <% List<String> errorMessages = (List<String>) request.getAttribute("errorMessages");
   				if (errorMessages != null && !errorMessages.isEmpty()) {
       			for (String errorMessage : errorMessages) {
           			out.println("<p>" + errorMessage + "</p>");
       			}
   			}
			%>
            <button type="submit">Cập nhật</button>
        </form>
    </div>
</body>
</html>