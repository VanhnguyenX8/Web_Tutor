<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimun-scale=1,maximum-scale=1, initial-scale=1.0">
    <link rel="stylesheet" href="css/dashboard/styleDashboardHome.css">
    <link rel="stylesheet"
          href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">

    <title>Dashboard</title>
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
            <div class="khoiben-anh" style="background-image: url(/asset/564835.jpg);"></div>
            <div class="user">
                <small>Software Developer</small>
                <p>Tuan Anh</p>
            </div>
        </div>
        <ul>
            <li class="dashboard">
                <a href="/Web_Tutor/home_dashboard" class="a-dash-board activate">
                    <span class="las la-home"></span>
                    <span>Dashboard</span>
                </a>
            </li>
            <li class="gia-su">
                <a href="/Web_Tutor/giasu" class="a-gia-su ">
                    <span class="las la-users"></span>
                    <span>Gia Sư</span>
                </a>
            </li>
            <li class="hoc-sinh">
                <a href="/Web_Tutor/hocsinh" class="a-hoc-sinh">
                    <span class="las la-users"></span>
                    <span>Học Sinh</span>
                </a>
            </li>
            <li class="lop-hoc">
                <a href="/Web_Tutor/lophoc" class="a-lop-hoc">
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
        <div class="nhieuthe">
            <div class="the">
                <div class="icon-the follow">
                    <span class="las la-users"></span>
                </div>
                <div class="thongtin-the">

                    <h2 id="so-luong-hoc-sinh">0</h2>
                    <small>Học Sinh </small>
                </div>
            </div>
            <div class="the">
                <div class="icon-the follow">
                    <span class="las la-users"></span>
                </div>
                <div class="thongtin-the">
                    <h2 id="so-luong-gia-su">0</h2>
                    <small>Gia Sư</small>
                </div>
            </div>
            <div class="the">
                <div class="icon-the follow">
                    <span class="las la-chalkboard-teacher"></span>
                </div>
                <div class=" thongtin-the">
                    <h2 id="so-luong-lop-hoc">0</h2>
                    <small>Lớp Học</small>
                </div>
            </div>
            <div class="the">
                <div class="icon-the likes">
                    <span class="las la-coins"></span>
                </div>
                <div class="thongtin-the">
                    <h2 id="doanh-thu">0</h2>
                    <small>Tổng doanh thu</small>
                </div>
            </div>
        </div>
        <div class="bieu-do">
            <div class="chart-1">
                <canvas id="profitChart"></canvas>
                <div id="lua-chon-nam" >

                    <label style="font-size: 24px;">Year <select name="year" id="year" style="font-size: 24px
                        ; border: none; outline: none;" onchange="drawChart1()">
                    </select></label>
                </div>
                <canvas id="pie" style=" background-color: #ffffff;"></canvas>
            </div>
            <div class="bieudo-2">
                <label style="margin: 4px
                    ;">Ngày bắt đầu</label>
                <input onchange="filterDate()" value="2023-05-01" type="date" id="startDate"
                       placeholder="Ngày bắt đầu" style="margin: 8px; font-size: 16px;">
                <label>Ngày kết thúc</label>
                <input onchange="filterDate()" value="2023-05-06" type="date" id="endDate"
                       placeholder="Ngày kết thúc" style="margin: 8px;font-size: 16px;">
                <canvas id="myChart2"></canvas>
            </div>

        </div>
    </main>
</div>
<label class="close-mobile-menu" for="menu-toggle"></label>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<script src="dashboardjs/dashboard-home.js"></script>

</body>
</html>