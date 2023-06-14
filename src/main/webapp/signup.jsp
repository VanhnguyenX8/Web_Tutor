<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" type="text/css" href="css/signup.css" />
  </head>
  <body>
  	<script>
    function handleCheckboxChange(checkbox) {
        var checkboxes = document.getElementsByName("position");
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i] !== checkbox) {
                checkboxes[i].checked = false;
            }
        }
    }
	</script>
    <h1>Tạo Tài Khoản của bạn!</h1>
    <p1>Học tập và giao lưu với hàng triệu học viên trên mọi miền đất nước!</p1>
    <div class="login">
      <h2>Người dùng đăng ký</h2>
      <form action="SignUpServlet" method="post">
      	<%
  			String mess = (String) request.getAttribute("mess");
  			if (mess != null && !mess.isEmpty()) {
		%>
      	<div class="alert-danger" role="alert"><%= mess %></div>
      	<%
  			}
		%>
		<%
		    String usernameError = (String) request.getAttribute("usernameError");
		    String passwordError = (String) request.getAttribute("passwordError");
		    String repasswordError = (String) request.getAttribute("repasswordError");
		%>
		
        <label for="username">Tài Khoản:</label>
        <input type="text" id="username" placeholder="Tài Khoản" name="username" required /><br />
        <% if (usernameError != null && !usernameError.isEmpty()) { %>
    		<div class="error"><%= usernameError %></div>
		<% } %>
        <label for="password">Mật Khẩu:</label>
        <input type="password" id="password" placeholder="Mật Khẩu" name="password" required /><br />
        <% if (passwordError != null && !passwordError.isEmpty()) { %>
    		<div class="error"><%= passwordError %></div>
		<% } %>
        <label for="repass">Nhập lại Mật Khẩu:</label>
        <input type="password" id="repass" placeholder="Nhập lại mật khẩu" name="repass" required /><br />
		<% if (repasswordError != null && !repasswordError.isEmpty()) { %>
    		<div class="error"><%= repasswordError %></div>
		<% } %>
        <input type="checkbox" id="giasu" name="position" value="giasu" onchange="handleCheckboxChange(this)" />
        <label for="giasu">Gia Sư</label>
        
        <input type="checkbox" id="hocsinh" name="position" value="hocsinh" onchange="handleCheckboxChange(this)"/>
        <label for="hocsinh">Học sinh</label>
        
        <br /><br />
        <input type="submit" id="submit" value="Signup" />
      </form>
    </div>
  </body>
</html>