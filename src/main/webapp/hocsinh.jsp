<%--
  Created by IntelliJ IDEA.
  User: tuana
  Date: 5/29/2023
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width,minimun-scale=1,maximum-scale=1, initial-scale=1.0">
  <link rel="stylesheet" href="./css/styleHocSinh.css">
  <link rel="stylesheet"
        href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
  <title>Dashboard</title>
  <script src="./js/hocsinh.js"></script>
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<input type="checkbox" id="menu-toggle">
<div class="khoiben">
  <div class="brand">
    <span class="lab la-affiliatetheme">CA</span>
    <h2>ArtStart</h2>
  </div>
  <div class="menu-khoiben">
    <div class="khoiben-user">
      <div class="khoiben-anh" style="background-image: url(/src/main/webapp/anhthe1.png);"></div>
      <div class="user">
        <small>Software Developer</small>
        <p>Tuan Anh</p>
      </div>
    </div>
    <ul>
      <li class="dashboard">
        <a href="http://localhost:8080/DashBoardWeb_war_exploded/home" class="a-dash-board">
          <span class="las la-home"></span>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="gia-su">
        <a href="http://localhost:8080/DashBoardWeb_war_exploded/giasu" class="a-gia-su ">
          <span class="las la-users"></span>
          <span>Gia Sư</span>
        </a>
      </li>
      <li class="hoc-sinh">
        <a href="http://localhost:8080/DashBoardWeb_war_exploded/hocsinh" class="a-hoc-sinh activate">
          <span class="las la-users"></span>
          <span>Học Sinh</span>
        </a>
      </li>
      <li class="lop-hoc">
        <a href="http://localhost:8080/DashBoardWeb_war_exploded/lophoc" class="a-lop-hoc">
          <span class="las la-school"></span>
          <span>Lớp Học</span>
        </a>
      </li>

    </ul>
  </div>
</div>

<div class="noidungchinh">
  <header>
    <label for="menu-toggle" class="menu-toggler">
      <span class="las la-bars follow"></span>
    </label>
    <div class="search">
      <span class="las la-search"></span>
      <input type="search" placeholder="Enter keyword">
    </div>
    <div class="icons-dau">
      <span class="las la-bell"></span>
      <span class="las la-bookmark"></span>
      <span class="las la-comment"></span>
    </div>
  </header>
  <main>
    <div class="table">
      <div class="sub_table">
        <div class="row-header">
          <div class="cell_header">Username</div>
          <div class="cell_header">Name</div>
          <div class="cell_header">Date Of Birth</div>
          <div class="cell_header">Gender</div>
          <div class="cell_header">Phone</div>
          <div class="cell_header">Email</div>
          <div class="cell_header">Address</div>
          <div class="cell_header">Bank Number</div>
          <div class="cell_header">Account Balance</div>
          <div class="cell_header">Permission</div>
        </div>
      </div>

      <!-- Thêm các dòng khác tương tự ở đây -->
    </div>
  </main>

</div>
<label class="close-mobile-menu" for="menu-toggle"></label>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>


</body>

</html>
