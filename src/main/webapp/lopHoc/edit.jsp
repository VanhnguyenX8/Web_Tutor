<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
	<meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/edit.css">

</head>
<body>
<div class="container emp-profile">
    <h1>Sửa Thông Tin Lớp Học</h1>
    <form method="post" action="${ pageContext.request.contextPath }/managerLopHoc?action=edit">
        <input placeholder="id" name="id" value="${lopHoc.id}" hidden="hidden"><br>
        <input placeholder="Tên Lớp Học" name="name" type="name" value="${lopHoc.tenLopHoc}"><br>
        <input placeholder="usernameHS" name="usernameHS" value="${lopHoc.usernameHocSinh}" hidden="hidden"><br>
        <input placeholder="Giờ Bắt Đầu" name="hour" type="number" value="${lopHoc.gioHoc}"><br>
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
        <input placeholder="date" name="date" type="date" value="${lopHoc.ngayHoc}"><br>
        <input placeholder="Phí Lớp Học" name="price" type="number" value="${lopHoc.hocPhi}"><br>
        <input placeholder="Phí Gia Sư" name="priceGS" type="number" value="${lopHoc.phiGiaSu}"><br>
        <input placeholder="Nội Dung" name="content" type="content" value="${lopHoc.moTa}"><br>
        <input placeholder="Hình Ảnh" name="img" type="img" value="${lopHoc.hinhAnh}"><br>

        <button type="submit" class="btn btn-success">Submit</button>
    </form>

</div>

</body>
</html>

