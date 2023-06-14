<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width,minimun-scale=1,maximum-scale=1, initial-scale=1.0">
  <link rel="stylesheet" href="css/dashboard/styleDashboardClass.css">
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
    <span class="lab la-affiliatetheme">HTT</span>
    <h2>Study</h2>
  </div>
  <div class="menu-khoiben">
    <div class="khoiben-user">
      <div class="khoiben-anh"></div>
      <div class="user">
                <small id="vitricongviec"></small>
                <p id="tenadmin"></p>
            </div>
    </div>
    <ul>
      <li class="dashboard">
        <a href="/Web_Tutor/home_dashboard" class="a-dash-board">
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
        <a href="/Web_Tutor/lophoc" class="a-lop-hoc activate">
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
          <div class="cell_header">ID</div>
          <div class="cell_header">Username Student</div>
          <div class="cell_header">Username Tutor</div>
          <div class="cell_header">Class Name</div>
          <div class="cell_header">Class Schedule</div>
          <div class="cell_header">Class Day</div>
          <div class="cell_header">Tuition</div>
          <div class="cell_header">Tutor's fee</div>
          <div class="cell_header">View</div>
          <div class="cell_header">Permission</div>
          <div class="cell_header">Permission</div>
        </div>

      </div>

      <!-- Thêm các dòng khác tương tự ở đây -->
    </div>
    <div id="myModal" class="modal">
      <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2>Description of information</h2>
        <table>
          <tr>
            <td colspan="2" id="image"></td>
          </tr>
          <tr>
            <td>Describe:</td>
            <td id="desc"></td>
          </tr>

        </table>
      </div>
    </div>

  </main>

</div>
<label class="close-mobile-menu" for="menu-toggle"></label>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<script src="dashboardjs/dashboard-class.js"></script>

</body>

</html>
