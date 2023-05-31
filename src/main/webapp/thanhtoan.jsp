<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng ký lớp học</title>
	<link rel="stylesheet" href="css/dangkyhoc.css">
</head>
<body>
	<div id="main" class="bao sua">
		<div id="noidung">
			<ul class="thanhngang" style="margin-bottom: 20px;">
				<li>
					<a href="linktieuhoc">Tiểu học</a>
				</li>
				<li>
					<a href="linkthcs">THCS</a>
				</li>
				<li>
					<a href="linkthpt">THPT</a>
				</li>
			</ul>
			<div>
				<h3>Tiểu học</h3>
				<ul>
					<li>
						<a href="linklop1">Lớp 1</a>
					</li>
					<li>
						<a href="linklop2">Lớp 2</a>
					</li>
					<li>
						<a href="linklop3">Lớp 3</a>
					</li>
					<li>
						<a href="linklop4">Lớp 4</a>
					</li>
					<li>
						<a href="linklop5">Lớp 5</a>
					</li>
				</ul>
			</div>
			<div>
				<ul id = "monhoc">
					<li>
						<a href="linktv">Tiếng Việt</a>
					</li>
					<li>
						<a href="linktoan">Toán</a>
					</li>
				</ul>
				<div id="khoahoc">
					<ul>
						<li>
							<div>Tên khóa học 1</div>
							<div>Giá tiền 1</div>
							<div>
								<a href="link chon 1">Chọn</a>
							</div>
						</li>
						<li>
							<div>Tên khóa học 2</div>
							<div>Giá tiền 2</div>
							<div>
								<a href="link chon 2">Chọn</a>
							</div>
						</li>
					</ul>
				</div>
				<div id = "khoahocdachon">
					<p>Bạn chưa chọn khóa học, để ẩn khi đã chọn</p>
					<ul id = "danhsachkhoahocdachon">
						<li>
							<div>
								<div>Tên khóa học</div>
								<div>Giá tiền</div>
							</div>
							<a href="bo">Dấu x</a>
						</li>
					</ul>
					<div>
						<div>Học phí</div>
						<div id ="tongtien">Tổng tiền</div>
						<a href="thanhtoan">Đăng ký học</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="tbkhichuachonlophoc">
		<div class="ndthongbao">
			<div class="thongbao-header">
				<h4>Lỗi</h4>
			</div>
			<div class="thongbao-body">
				<p>Bạn chưa chọn bất ký lớp học nào</p>
			</div>
			<div class="thongbao-footer">
				<button>Đóng</button>
			</div>
		</div>
	</div>
	<div class="thongbaokhidachonlophoc">
		<div class="thongbao">
			<div class="ndthongbao">
				<div class="thongbao-header">
					<h4>Xác nhận đăng ký học</h4>
				</div>
				<div class="thongbao-body">
					<ul class="khoahocdachon">
						<li>
							<div>Tên lóp học</div>
							<div>Giá tiền</div>
						</li>
						<li>
							<div>Tên lóp học2</div>
							<div>Giá tiền2</div>
						</li>
					</ul>
					<div class="thanhtoanhocphi">
						<div class="hocphi">
							<div>Học phí</div>
							<div>Tổng tiền</div>
						</div>
						<div class="tientrongtaikhoan">
							<div>Tài khoản chính có</div>
							<div>Tiền trong tài khoản chính</div>
						</div>
						<div class="tienconthieu">
							<div>Còn thiếu</div>
							<div>Tiền còn thiếu</div>
						</div>
					</div>
				</div>
				<div class="thongbao-footer">
					<button>Chọn lại lớp học</button>
					<a id="napthien" href="linknaptien">Nạp thêm tiền</a>
					<a id="xacnhanthanhtoan" href="suadoidatabase">Thanh toán</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>