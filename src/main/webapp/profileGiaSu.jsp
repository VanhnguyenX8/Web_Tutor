<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <meta charset="UTF-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body {
            background: -webkit-linear-gradient(left, #3931af, #00c6ff);
        }
        .emp-profile {
            padding: 3%;
            margin-top: 3%;
            margin-bottom: 3%;
            border-radius: 0.5rem;
            background: #fff;
        }

        .profile-img {
            text-align: center;
        }

        .profile-img img {
            width: 70%;
            height: 100%;
        }

        .profile-img .file {
            position: relative;
            overflow: hidden;
            margin-top: -20%;
            width: 70%;
            border: none;
            border-radius: 0;
            font-size: 15px;
            background: #212529b8;
        }

        .profile-img .file input {
            position: absolute;
            opacity: 0;
            right: 0;
            top: 0;
        }

        .profile-head h5 {
            color: #333;
        }

        .profile-head h6 {
            color: #0062cc;
        }

        .profile-edit-btn {
            border: none;
            border-radius: 1.5rem;
            width: 70%;
            padding: 2%;
            font-weight: 600;
            color: #6c757d;
            cursor: pointer;
        }

        .proile-rating {
            font-size: 12px;
            color: #818182;
            margin-top: 5%;
        }

        .proile-rating span {
            color: #495057;
            font-size: 15px;
            font-weight: 600;
        }

        .profile-head .nav-tabs {
            margin-bottom: 5%;
        }

        .profile-head .nav-tabs .nav-link {
            font-weight: 600;
            border: none;
        }

        .profile-head .nav-tabs .nav-link.active {
            border: none;
            border-bottom: 2px solid #0062cc;
        }

        .profile-work {
            padding: 14%;
            margin-top: -15%;
        }

        .profile-work p {
            font-size: 12px;
            color: #818182;
            font-weight: 600;
            margin-top: 10%;
        }

        .profile-work a {
            text-decoration: none;
            color: #495057;
            font-weight: 600;
            font-size: 14px;
        }

        .profile-work ul {
            list-style: none;
        }

        .profile-tab label {
            font-weight: 600;
        }

        .profile-tab p {
            font-weight: 600;
            color: #0062cc;
        }
        .capnhatthongtin > a{
        	text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container emp-profile">
    <form method="post">
        <div class="row">
        <%
        String username = (String) session.getAttribute("username");
        String position = (String) session.getAttribute("position");
        %>
        <% if("giasu".equals(position)){
        %>
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="${giaSu.hinh_anh}" alt=""/>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        ${giaSu.ten_gia_su}
                    </h5>
                    <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                               aria-controls="home" aria-selected="true">About</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <a type="submit" class="btn btn-primary" name="btnAddMore" href="/Web_Tutor/Home">Home</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-work">
                    <p>SKILLS</p>
                    <a href="">Web Designer</a><br/>
                    <a href="">Web Developer</a><br/>
                    <a href="">PHP, .Net</a><br/>
                </div>
            </div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6"><label>User Id</label></div>
                            <div class="col-md-6"><p>${giaSu.id}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Name</label></div>
                            <div class="col-md-6"><p>${giaSu.ten_gia_su}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Email</label></div>
                            <div class="col-md-6"><p>${giaSu.email}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Phone</label></div>
                            <div class="col-md-6"><p>${giaSu.sdt}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Bank</label></div>
                            <div class="col-md-6"><p>${giaSu.so_du_tai_khoan}</p></div>
                        </div>
                    </div>
                </div>
                <button class="capnhatthongtin"><a href="/Web_Tutor/UpdateInfo">Cập Nhật Thông tin</a></button>
            </div>
            <% } %>
            <% if("hocsinh".equals(position)){
        	%>
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="${hocSinh.hinh_anh}" alt=""/>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        ${hocSinh.ten_hoc_sinh}
                    </h5>
                    <p class="proile-rating"></p>
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                               aria-controls="home" aria-selected="true">About</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <a type="submit" class="btn btn-primary" name="btnAddMore" href="/Web_Tutor/Home">Home</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-work">
                    <p>SKILLS</p>
                    <a href="">Web Designer</a><br/>
                    <a href="">Web Developer</a><br/>
                    <a href="">PHP, .Net</a><br/>
                </div>
            </div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6"><label>User Id</label></div>
                            <div class="col-md-6"><p>${hocSinh.id}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Name</label></div>
                            <div class="col-md-6"><p>${hocSinh.ten_hoc_sinh}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Email</label></div>
                            <div class="col-md-6"><p>${hocSinh.email}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Phone</label></div>
                            <div class="col-md-6"><p>${hocSinh.sdt}</p></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Bank</label></div>
                            <div class="col-md-6"><p>${hocSinh.so_du_tai_khoan}</p></div>
                        </div>
                    </div>
                </div>
                <button class="capnhatthongtin"><a href="/Web_Tutor/UpdateInfo">Cập Nhật Thông tin</a></button>
            </div>
            <% } %>
        </div>
    </form>
    </div>
</body>
</html>