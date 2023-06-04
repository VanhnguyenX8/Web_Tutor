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
		  	<button class="nutBacHoc">Tiểu học</button>
		 	<button class="nutBacHoc">THCS</button>
		  	<button class="nutBacHoc">THPT</button>
		  	
		</div>
		<div class="trai">
			<h3 id="bacHoc">Trung học phổ thông</h3>
			<div class="nhomNut">
				<button class="nutLop">Lớp 1</button>
				<button class="nutLop">Lớp 2</button>
			  	<button class="nutLop">Lớp 3</button>
			  	<button class="nutLop">Lớp 4</button>
			  	<button class="nutLop">Lớp 5</button>
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
				<li><button class="nutMon">Toán</button></li>
				<li><button class="nutMon">Tiếng Việt</button></li>
			</ul>
			<div class="lopHoc">
				<ul>
					<li>
						<div class="tenLop">Toán 1</div>
						<div class="giaoVien">Giáo Viên: Nguyễn Văn A</div>
						<div class="hocPhi">100000đ</div>
						<div><button class="chon">Chọn</button></div>
					</li>
					<li>
						<div class="tenLop">Tiếng Việt 1</div>
						<div class="giaoVien">Giáo Viên: Nguyễn Văn B</div>
						<div class="hocPhi">200000đ</div>
						<div><button class="chon">Chọn</button></div>
					</li>
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