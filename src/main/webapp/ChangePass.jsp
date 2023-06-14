<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đổi mật khẩu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
        }
        
        label {
            display: block;
            margin-bottom: 10px;
        }
        
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }
        
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Đổi mật khẩu</h1>
        <%
		    String confirmError = (String) request.getAttribute("repassError");
		    String oldpassError = (String) request.getAttribute("oldpassError");
		    String newPassError = (String) request.getAttribute("newpassError");
		%>
        <form action="ChangePassword" method="post">
            <label for="oldPassword">Mật khẩu cũ:</label>
            <input type="password" id="oldPassword" name="oldPassword" required><br>
            <% if (oldpassError != null && !oldpassError.isEmpty()) { %>
    			<div class="error"><%= oldpassError %></div>
			<% } %>

            <label for="newPassword">Mật khẩu mới:</label>
            <input type="password" id="newPassword" name="newPassword" required><br>
			<% if (newPassError != null && !newPassError.isEmpty()) { %>
    			<div class="error"><%= newPassError %></div>
			<% } %>

            <label for="confirmPassword">Nhập lại mật khẩu mới:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required><br>
			<% if (confirmError != null && !confirmError.isEmpty()) { %>
    			<div class="error"><%= confirmError %></div>
			<% } %>

            <input type="submit" value="Đổi mật khẩu">
        </form>
    </div>
</body>
</html>
