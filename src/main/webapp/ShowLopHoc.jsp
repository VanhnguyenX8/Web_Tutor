<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="css/showAllLop.css">
</head>
<body>
 <body>
    <div class="container emp-profile">
        <div class="header">
            <div class="wrapper">
                <div class="search">
                    <div>
                        <input type="text" class="search-key" />
                    </div>

                </div>
                <div class="logo2">
                    <a href="Home"><img src="img/logo.png"></a>
                </div>
                <div class="action">
                    <ul>
                        <li>
                            <button class="btn1"><a href="/Web_Tutor/TaiKhoanServlet">Đăng
                                    Nhập</a></button>
                        </li>
                        <li>
                            <button class="btn2"><a href="/Web_Tutor/signup.jsp">Đăng
                                    Kí</a></button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <h1>Danh sách tất cả lớp học</h1>

        <c:forEach var="lh" items="${lopHocs}">
            <div class="wapper">
                <div class="table-item">
                    <img src="${lh.hinhAnh}" alt="" width="200" height="160">
                    <br>
                    <p>${lh.tenLopHoc}</p>
                    <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                    <p>${lh.moTa}</p>
                    <a href="profileLH?id=${lh.id }">Thông tin lớp học</a>
                </div>
            </div>
        </c:forEach>

    </div>


</body>

</html>
