<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
	    <label for="name">Tên:</label>
	    <input type="text" id="name" name="name" required>
	    <br>
	    <input type="submit" value="Submit">
 	</form>
</body>
</html>