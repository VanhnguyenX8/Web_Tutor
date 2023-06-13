<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/create.css">

</head>
<body>
<div class="container emp-profile">
    <h1>Tạo Lớp Học</h1>
    <form method="post" action="${ pageContext.request.contextPath }/managerLopHoc?action=create">
<%--        <input placeholder="id" name="id"><br>--%>
        <input placeholder="Tên Lớp Học" type="name" name="name"><br>
        <input placeholder="Giờ Bắt Đầu" type="number" name="hour"><br>
        <select name="lever">
            <option value="1">Khối 1</option>
            <option value="2">Khối 2</option>
            <option value="3">Khối 3</option>
            <option value="4">Khối 4</option>
            <option value="5">Khối 5</option>
            <option value="6">Khối 6</option>
            <option value="7">Khối 7</option>
            <option value="8">Khối 8</option>
            <option value="9">Khối 9</option>
            <option value="10">Khối 10</option>
            <option value="11">Khối 11</option>
            <option value="12">Khối 12</option>
        </select>
        <input placeholder="date" name="date" type="date"><br>
        <input placeholder="Phí Lớp Học" name="price" type="number"><br>
        <input placeholder="Phí Gia Sư" name="priceGS" type="number"><br>
        <input placeholder="Nội Dung" type="content" name="content"><br>
        <input placeholder="Ảnh Lớp Học" type="img" name="img"><br>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>

</div>

</body>
</html>

