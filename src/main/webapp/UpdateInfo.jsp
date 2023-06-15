<%@page import="Model.UserHS"%>
<%@page import="Model.UserGS"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhập thông tin</title>
 <link rel="stylesheet" type="text/css" href="css/themthongtin.css" />
 <style>
 	.btn {
 	text-decoration: none;
    border: none;
    border-radius: 1.5rem;
    width: 70%;
    padding: 2%;
    margin-top:10px;
    font-weight: 600;
    color: #6c757d;
	cursor: pointer;}
 </style>
</head>
<body>
	<div class="container">
        <h2>Cập nhật thông tin cá nhân</h2>
        <div class="col-md-2">
        	<a type="submit" class="btn btn-primary" name="btnAddMore" href="/Web_Tutor/Home">Home</a>
		</div>
        <form action="UpdateInfo" method="post" >
        <%
        String username = (String) session.getAttribute("username");
        String position = (String) session.getAttribute("position");
        %>
        <% if("giasu".equals(position)){
        %>
            <div class="form-group">
			    <label for="name">Họ Và Tên:</label>
			    <input type="text" id="name" name="name" value="${giaSu.ten_gia_su}" required>
			</div>
			<div class="form-group">
			    <label for="ngaySinh">Năm Sinh:</label>
			    <input type="date" id="ngaySinh" name="ngaySinh" value="${giaSu.nam_sinh}" %>">
			</div>
			<div class="form-group">
			    <label for="phone">Số điện thoại:</label>
			    <input type="tel" id="phone" name="phone" value="${giaSu.sdt}" required>
			</div>
			<div class="form-group">
			    <label for="email">Email:</label>
			    <input type="email" id="email" name="email" value="${giaSu.email}" required>
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
                <textarea id="address" name="address" value="${giaSu.dia_chi}" required></textarea>
            </div>
            <div class="form-group">
                <label for="bankAccount">Số tài khoản:</label>
                <input type="text" id="bankAccount" name="bankAccount" value="${giaSu.sotaikhoan}" required>
            </div>
            <button type="submit">Cập nhật</button>
            <% } %>
            <% if("hocsinh".equals(position)){
        %>
            <div class="form-group">
			    <label for="name">Họ Và Tên:</label>
			    <input type="text" id="name" name="name" value="${hocSinh.ten_hoc_sinh}" required>
			</div>
			<div class="form-group">
			    <label for="ngaySinh">Năm Sinh:</label>
			    <input type="date" id="ngaySinh" name="ngaySinh" value="${hocSinh.nam_sinh}" %>">
			</div>
			<div class="form-group">
			    <label for="phone">Số điện thoại:</label>
			    <input type="tel" id="phone" name="phone" value="${hocSinh.sdt}" required>
			</div>
			<div class="form-group">
			    <label for="email">Email:</label>
			    <input type="email" id="email" name="email" value="${hocSinh.email}" required>
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
                <textarea id="address" name="address" value="${hocSinh.dia_chi}" required></textarea>
            </div>
            <div class="form-group">
                <label for="bankAccount">Số tài khoản:</label>
                <input type="text" id="bankAccount" name="bankAccount" value="${hocSinh.so_tai_khoan}" required>
            </div>
            <button type="submit">Cập nhật</button>
            <% } %>
        </form>
    </div>
</body>
</html>