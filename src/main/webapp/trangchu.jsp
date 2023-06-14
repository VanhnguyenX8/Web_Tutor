<%@page import="java.util.List"%>
<%@ page import="Service.LopHocService" %>
<%@ page import="Model.UserGS" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="Controller.HomeServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Trang chủ</title>
    <link rel="stylesheet" href="css/trangchu.css" />
	<script type="text/javascript" src="/js/home.js"></script>
    <script
      src="https://kit.fontawesome.com/b7bb3a4b72.js"
      crossorigin="anonymous"></script>
  </head>
  <body>
    <!-- Phần đầu -->
    <div id="toanbotrang">
      <div id="phandau">
        <div class="baobocitemphandau">
          <div class="menucackhoahoc">
            <div class="vungkichhoatmenu">
              <i class="fa-solid fa-bars"></i>
              <span class="motabieutuong" style="padding-right: 5px; color: white">Các khóa học</span>
            </div>
          </div>
          <div id="timkiem">
            <input type="text" class="input" placeholder="Tìm kiếm khóa học" />
            <button type="submit" class="nuttimkiem">
              <i class="fa fa-search"></i>
            </button>
          </div>

          <img class="anhiconlogo" src="logo." alt="" />
          <div class="nguoidung">
          <%
		    // Lấy thông tin từ session
		    Object value = session.getAttribute("acc");
		    String position = (String) request.getAttribute("position");
		    String username = (String) session.getAttribute("username");
		    
		  %>
		  <% if ("admin".equals(position)) { %>
		  	<li class="thongtin-nguoidung">
              <a href="" class="avt items">
                <div class="avt-box"></div>
              </a>
              <div class="danhsach sub">
                <ul class="danhsachcon">
                  <li class="taikhoan">
                    <div class="avatar"></div>
                    <div class="thongtin">
                      <p class="ten">Admin</p>
                    </div>
                  </li>
                  <li>
                    <button onclick="redirectDashboard.bind(null, '<%= username %>')()" >
                      <span>DashBoard</span>
                    </button>
                  </li>
                  <li>
                    <a href="Home?logout=true" class="link">
                      <span>Đăng xuất</span>
                    </a>
                  </li>
                </ul>
              </div>
            </li>
		  <%} %>
		  <% if ("mod".equals(position)) { %>
		  	<li class="thongtin-nguoidung">
              <a href="" class="avt items">
                <div class="avt-box"></div>
              </a>
              <div class="danhsach sub">
                <ul class="danhsachcon">
                  <li class="taikhoan">
                    <div class="avatar"></div>
                    <div class="thongtin">
                      <p class="ten">Mod</p>
                    </div>
                  </li>
                  <li>
                    <a href="/Web_Tutor/managerLopHoc" class="link">
                      <span>Quản lý lớp học</span>
                    </a>
                  </li>
                  <li>
                    <a href="Home?logout=true" class="link">
                      <span>Đăng xuất</span>
                    </a>
                  </li>
                </ul>
              </div>
            </li>
		  <%} %>
		  <% if (position.equals("giasu")) { %>
			<li class="thongtin-nguoidung">
              <a href="" class="avt items">
                <div class="avt-box"></div>
              </a>
              <div class="danhsach sub">
                <ul class="danhsachcon">
                  <li class="taikhoan">
                    <div class="avatar"></div>
                    <div class="thongtin">
                    <%
    					String Name = (String) request.getAttribute("Name");
                    	String email = (String) request.getAttribute("email");
					%>
                      <p class="ten"><%= Name %></p>
                      <p class="email"><%= email %></p>
                    </div>
                  </li>
                  <li>
                    <a href="/Web_Tutor/profileGS" class="link">
                      <span>Thông tin cá nhân</span>
                    </a>
                  </li>
                  <li>
                    <a href="/Web_Tutor/managerLopHoc" class="link">
                      <span>Quản lý lớp học</span>
                    </a>
                  </li>
                  <li>
                    <a href="" class="link">
                      <span>Đổi mật khẩu</span>
                    </a>
                  </li>
                  <li>
                    <a href="Home?logout=true" class="link">
                      <span>Đăng xuất</span>
                    </a>
                  </li>
                </ul>
              </div>
            </li>			        
			<% } %>
          <% if (position.equals("hocsinh")) { %>
			<li class="thongtin-nguoidung">
              <a href="" class="avt items">
                <div class="avt-box"></div>
              </a>
              <div class="danhsach sub">
                <ul class="danhsachcon">
                  <li class="taikhoan">
                    <div class="avatar"></div>
                    <div class="thongtin">
                    <%
    					String Name = (String) request.getAttribute("Name");
                    	String email = (String) request.getAttribute("email");
					%>
                      <p class="ten"><%= Name %></p>
                      <p class="email"><%= email %></p>
                    </div>
                  </li>
                  <li>
                    <a href="/Web_Tutor/profileGS" class="link">
                      <span>Thông tin cá nhân</span>
                    </a>
                  </li>
                  <li>
                    <a href="" class="link">
                      <span>Đổi mật khẩu</span>
                    </a>
                  </li>
                  <li>
                    <a href="Home?logout=true" class="link">
                      <span>Đăng xuất</span>
                    </a>
                  </li>
                </ul>
              </div>
            </li>			        
			<% } %>
          </div>
          
          
          <div  class="lop-hoc-ddk">
       	  	<a href="lopHocDaDangKy.jsp?acc=<%=username%>">Lớp học đã đăng ký</a>
       	  </div>
	      <div class="gio-hang">
	      	Khóa học của tôi
	      	<div class="items">
	      		<a href="dangKyTieuHoc.jsp?acc=<%=username%>">Tiểu học</a>
	      		<br>
	      		<a href="dangKyTHCS.jsp?acc=<%=username%>">THCS</a>
	      		<br>
	      		<a href="dangKyTHPT.jsp?acc=<%=username%>">THPT</a>
	      	</div>
		  </div>
		  
		  
        </div>
      </div>
      <div id="khoahoc-content">
        <div class="wrapper-khoahoc">
          <div class="duongdan"></div>
          <div class="conten-wrapper"></div>
        </div>
      </div>


      <div class="container_border_banner">
      <!-- Trung học phổ thông -->
      <div id="thcs" class="main-thcs">
        <div class="container">
            <div class="tieude">
                <div class="tieude-thcs">Trung Học Phổ Thông</div>
            </div>
            <div class="noi-dung-1">
                <div class="quangcao">
                    <div class="quangcao-img"><a href=""><img src="img/banner.png" alt="lotrinhhoctot"></a></div>
                </div>
                <div class="lop-hoc-moi">
                    <c:forEach var="lh" items="${list3lv3}">
                    <div id="lop-hoc-1" class="lop-hoc">
                        <img src="${lh.hinhAnh}" alt="" width="200" height="200">
                        <div class="thong-tin-lop-hoc">
                            <table>
                                <p><a href="profileGS?username=${lh.usernameGiaSu}">Giáo Viên: ${lh.usernameGiaSu}</a>
                                </p>
                                <p1>${lh.tenLopHoc}</p1>
                                <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                                <a href="profileLH?id=${lh.id }">thông tin lớp học</a>
                            </table>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="noi-dung-2">
                <div class="lop-hoc-hot">
                    <c:forEach var="lh" items="${list4lv3}">
                    <div id="lop-hoc-4" class="lop-hoc">
                        <img src="${lh.hinhAnh}" alt="" width="200" height="200">
                        <div class="thong-tin-lop-hoc">
                            <div class="thong-tin-lop-hoc">
                                <table>
                                    <p><a href="profileGS?username=${lh.usernameGiaSu}">Giáo Viên:
                                            ${lh.usernameGiaSu}</a>
                                    </p>
                                    <p1>${lh.tenLopHoc}</p1>
                                    <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                                    <a href="profileLH?id=${lh.id }">thông tin lớp học</a>
                                </table>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div id="thcs" class="main-thcs">
        <div class="container">
            <div class="tieude">
                <div class="tieude-thcs">Trung Học Cơ Sở</div>
            </div>
            <div class="noi-dung-1">
                <div class="quangcao">
                    <div class="quangcao-img"><a href=""><img src="img/banner.png" alt="lotrinhhoctot"></a></div>
                </div>
                <div class="lop-hoc-moi">
                    <c:forEach var="lh" items="${list3lv2}">
                    <div id="lop-hoc-1" class="lop-hoc">
<img src="${lh.hinhAnh}" alt="" width="200" height="200">
                        <div class="thong-tin-lop-hoc">
                            <table>
                                <p><a href="profileGS?username=${lh.usernameGiaSu}">Giáo Viên: ${lh.usernameGiaSu}</a>
                                </p>
                                <p1>${lh.tenLopHoc}</p1>
                                <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                                <a href="profileLH?id=${lh.id }">thông tin lớp học</a>
                            </table>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="noi-dung-2">
                <div class="lop-hoc-hot">
                    <c:forEach var="lh" items="${list4lv2}">
                    <div id="lop-hoc-4" class="lop-hoc">
                        <img src="${lh.hinhAnh}" alt="" width="200" height="200">
                        <div class="thong-tin-lop-hoc">
                            <div class="thong-tin-lop-hoc">
                                <table>
                                    <p><a href="profileGS?username=${lh.usernameGiaSu}">Giáo Viên:
                                            ${lh.usernameGiaSu}</a>
                                    </p>
                                    <p1>${lh.tenLopHoc}</p1>
                                    <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                                    <a href="profileLH?id=${lh.id }">thông tin lớp học</a>
                                </table>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div id="thcs" class="main-thcs">
        <div class="container">
            <div class="tieude">
                <div class="tieude-thcs">Tiểu Học</div>
            </div>
            <div class="noi-dung-1">
                <div class="quangcao">
                    <div class="quangcao-img"><a href=""><img src="img/banner.png" alt="lotrinhhoctot"></a></div>
                </div>
                <div class="lop-hoc-moi">
                    <c:forEach var="lh" items="${list3lv1}">
                    <div id="lop-hoc-1" class="lop-hoc">
                        <img src="${lh.hinhAnh}" alt="" width="200" height="200">
                        <div class="thong-tin-lop-hoc">
                            <table>
                                <p><a href="profileGS?username=${lh.usernameGiaSu}">Giáo Viên: ${lh.usernameGiaSu}</a>
                                </p>
                                <p1>${lh.tenLopHoc}</p1>
                                <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                                <a href="profileLH?id=${lh.id }">thông tin lớp học</a>
                            </table>
                        </div>
</div>
                    </c:forEach>
                </div>
            </div>
            <div class="noi-dung-2">
                <div class="lop-hoc-hot">
                    <c:forEach var="lh" items="${list4lv1}">
                    <div id="lop-hoc-4" class="lop-hoc">
                        <img src="${lh.hinhAnh}" alt="" width="200" height="200">
                        <div class="thong-tin-lop-hoc">
                            <div class="thong-tin-lop-hoc">
                                <table>
                                    <p><a href="profileGS?username=${lh.usernameGiaSu}">Giáo Viên:
                                            ${lh.usernameGiaSu}</a>
                                    </p>
                                    <p1>${lh.tenLopHoc}</p1>
                                    <p>${lh.ngayHoc} - ${lh.hocPhi}$</p>
                                    <a href="profileLH?id=${lh.id }">thông tin lớp học</a>
                                </table>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
    <div class="wrapper-ft ">
        <div class="content-top">
            <div class="footer-block">
                <h3>VỀ HOCMAI</h3>
                <ul class="footer-block-list">
                    <li>
                        <a href="">Giới thiệu</a>
                    </li>
                    <li>
                        <a href="">Giáo viên nổi tiếng</a>
                    </li>
                    <li>
                        <a href="">Hệ thống trung tâm HOCMAI</a>
                    </li>
                    <li>
                        <a href="">Học sinh tiêu biểu</a>
                    </li>
                    <li>
                        <a href="">Điều khoản chính sách</a>
                    </li>
                    <li>
                        <a href="">Quy chế hoạt động</a>
                    </li>
                    <li>
                        <a href="">Chính sách bảo mật thông tin</a>
                    </li>
                    <li>
                        <a href="">Giải quyết khiếu nại, tranh chấp</a>
                    </li>
                    <li>
                        <a href="">Tuyển dụng</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>DỊCH VỤ</h3>
                <ul class="footer-block-list">
                    <li>
                        <a href="">Thư viện</a>
                    </li>
                    <li>
                        <a href="">Ôn luyện</a>
                    </li>
                    <li>
                        <a href="">Diễn đàn HOCMAI</a>
                    </li>
                    <li>
                        <a href="">Speakup - Tiếng Anh 1 kèm 1 Online</a>
                    </li>
                    <li>
                        <a href="">ICANTECH - Đào tạo Công nghệ & Lập trình</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>HỖ TRỢ KHÁCH HÀNG</h3>
                <ul class="footer-block-list">
                    <li>
                        <a href="">Trung tâm hỗ trợ</a>
                    </li>
                    <li>
                        <a>Email: hotro@hocmai.vn</a>
                    </li>
                    <li>
                        <a>Đường dây nóng: 1900 6933</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>DÀNH CHO ĐỐI TÁC</h3>
                <ul class="footer-block-list">
                    <li>
                        <a>Email: info@hocmai.vn</a>
                    </li>
                    <li>
                        <a>Tel: +84 (24) 3519-0591</a>
                    </li>
                    <li>
                        <a>Fax: +84 (24) 3519-0587</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>TẢI ỨNG DỤNG HOCMAI</h3>
                <a href=""><img class="footer-img-app" src="../assets/images/footer-google-app.png"></a>
                <a href=""><img class="footer-img-app" src="../assets/images/footer-store-app.png"></a>
                <a href=""><img class="footer-img-app" src="../assets/images/congthuong.png"></a>
            </div>
        </div>
    </div>
    <div class="wrapper-ft">
        <div class="row">
            <div class="row-left">
                <p>
                    Cơ quan chủ quản: Công ty Cổ phần Đầu tư và Dịch vụ Giáo dục <br> MST: 0102183602 do Sở kế
                    hoạch và Đầu tư thành phố Hà Nội cấp ngày 13 tháng 03 năm 2007 <br> Địa chỉ: <br> - Văn
                    phòng Hà Nội: Tầng 4, Tòa nhà 25T2, Đường Nguyễn Thị Thập, Phường Trung Hoà, Quận Cầu Giấy,
                    Hà Nội. <br> - Văn phòng TP.HCM: 13M đường số 14 khu đô thị Miếu Nổi, Phường 3, Quận Bình
                    Thạnh, TP. Hồ Chí Minh <br> Hotline: 19006933 – Email: hotro@hocmai.vn <br> Chịu trách nhiệm
                    nội dung: Phạm Giang Linh
                </p>
            </div>
            <div class="row-right"></div>
        </div>
    </div>
</div>
<script>
function redirectDashboard(username){
	localStorage.setItem("username",username);
	location.replace("/Web_Tutor/home_dashboard")
	}
</script>
</body>
</html>

