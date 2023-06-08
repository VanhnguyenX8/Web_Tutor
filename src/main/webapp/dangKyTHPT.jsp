<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Test</title>
	<link rel="stylesheet" href="css/trangDangKy.css">
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div class="nhomNut">
		  	<button class="nutBacHoc" onclick="redirectToPage('dangKyTieuHoc.jsp')">Tiểu học</button>
		 	<button class="nutBacHoc" onclick="redirectToPage('dangKyTHCS.jsp')">THCS</button>
		  	<button class="nutBacHoc">THPT</button>
		  	
		</div>
		<div class="trai">
			<h3 id="bacHoc">Trung học phổ thông</h3>
			<div class="nhomNut">
				
			</div>
		</div>
		<div class="nhan">
			<ul>
				<li>Môn</li>
				<li>Chọn lớp học</li>
				<li>Lớp học sẽ đăng ký</li>
			</ul>
		</div>
		<div class="nhomNut">
			<ul>
				
			</ul>
			<div class="lopHoc">
				<ul>
					
				</ul>
			</div>
			<div class="lopHocDaChon">
				<p id="chuaChonLopHoc">Bạn chưa chọn bất kỳ khóa học nào, vui lòng chọn khóa học muốn đăng ký bên trái.</p>
				<ul>
					
				</ul>
				<div>
					<div class="nhanHocPhi">Học phí</div>
					<div id="hocPhi">0đ</div>
				</div>
				<div class="xoa"><button id="dangKy">Đăng ký lớp học</button></div>
			</div>
		</div>
	</div>
	<div id="thongBao">
		<div id="rong" >
			<div id="thongBaoHeader">
				<h4>Lỗi</h4>
			</div>
			<div id="thongBaoMain">
				<p>Bạn chưa chọn bất kỳ lớp học nào</p>
			</div>
			<div id="thongBaoFooter">
				<button class="dongThongBao">Đóng</button>
			</div>
		</div>
		<div id="khongRong">
			<div id="thongBaoHeader">
				<h4>Xác nhận đăng ký học</h4>
			</div>
			<div id="thongBaoMain">
				<ul>
					
				</ul>
				<div class="tien">
					<div class="hocPhi">
						<div class="nhan">Học phí</div>
						<div class="soLuong"></div>
					</div>
					<div class="soDu">
						<div class="nhan">Tài khoản chính có</div>
						<div class="soLuong">100000đ</div>
					</div>
					<div class="thieu">
						<div class="nhan">Còn thiếu</div>
						<div class="soLuong"></div>
					</div>
				</div>
			</div>
			<div id="thongBaoFooter">
				<button class="dongThongBao">Đóng</button>
				<button id="napThemTien">Nạp thêm tiền</button>
				<button id="xacNhanDangKy">Đăng ký</button>
			</div>
		</div>
	</div>
	<div id="footer"></div>
	<script src="js/trangDangKy.js"></script>
</body>
</html>