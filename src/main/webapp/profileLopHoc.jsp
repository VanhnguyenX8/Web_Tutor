<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 30/05/2023
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/profileLH.css">
<title>MASTER</title>
</head>

<body>
	<div class="page">
		<div class="header">
			<div class="wrapper">
				<div class="logo1">
					<a> <i class="fa-solid fa-bars">Các khoá học</i>
					</a>
				</div>
				<div class="search">
					<div>
						<input type="text" class="search-key" />
					</div>
					<div>
						<input type="submit" class="search-btn" onclick="alert('OK')"></input>
					</div>

				</div>
				<div class="logo2">
					<a href="${ pageContext.request.contextPath }/Home"><img
						src="img/logo.png"></a>
				</div>
				<div class="action">
					<ul>
						<li>
							<button class="btn1" onclick="alert('Đăng nhập')">Đăng
								nhập</button>
						</li>
						<li>
							<button class="btn2" onclick="alert('Đăng ký')">Đăng ký</button>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="content">
			<a class="home-1-icon"
				href="${ pageContext.request.contextPath }/Home">Trang chủ</a>
			<div>
				<h1>${lopHoc.tenLopHoc}${lopHoc.lever}</h1>
			</div>
			<div class="content-wr">
				<p>${lopHoc.moTa}</p>
			</div>
			<div class="content-mid">
				<div>
					<div class="video">
						<img src="${lopHoc.hinhAnh}">
						<!-- Hien thi like va danh gia sao -->
						<div style="width: 500px">

							<%
							boolean hasLiked = false;
							double averageRating = (double) request.getAttribute("averageRating");
							int tongSoLuotThich = (int) request.getAttribute("tongSoLuotThich");
							int totalRatings = (int) request.getAttribute("totalRatings");
							int userRating = (int) request.getAttribute("userRating");
							if (request.getAttribute("hasLiked") != null) {
								hasLiked = (Boolean) request.getAttribute("hasLiked");
							}
							session.setAttribute("hasLiked", hasLiked);
							%>
							<ul class="fix_ngang">
								<li>
									<%
									if (hasLiked) {
									%>
									<form action="LikeServlet" method="post">
										<input type="hidden" name="like" value="true">
										<button class="like-button">Đã thích</button>
									</form> <%
 } else {
 %>
									<form action="LikeServlet" method="post">
										<input type="hidden" name="like" value="true">
										<button class="no-like-button">Thích</button>
									</form> <%
 }
 %>
									<p>

										<%=tongSoLuotThich%>
										lượt thích
								</li>

								<li>

									<form action="RatingServlet" method="post">

										<label>Chọn số sao:</label> <select name="rating">
											<option value="<%=userRating%>" selected><%=userRating%>
												sao
											</option>
											<option value="1">1 sao</option>
											<option value="2">2 sao</option>
											<option value="3">3 sao</option>
											<option value="4">4 sao</option>
											<option value="5">5 sao</option>
										</select> <br> <input style="margin-top: 20px" type="submit"
											value="Đánh giá">
									</form>

								</li>

							</ul>




						</div>
						<script>
							var likeButton = document
									.querySelector(".like-button");
							var likeForm = document.getElementById("like-form");

							likeButton.addEventListener("click", function() {
								likeForm.submit();
							});
						</script>
					</div>
					<div class="smenu">
						<ul>
							<li><a href="">Mô tả khóa học</a></li>
							<li><a href="">Đề cương khóa học</a></li>
							<li><a href="">Bài giảng miễn phí</a></li>
							<li><a href="">Giáo viên giảng dạy</a></li>
						</ul>
					</div>
				</div>
				<div class="block-course">
					<h3 class="course-title" style="color: #2a70b8;">Học ngay chỉ
						với</h3>
					<div class="text-center">
						<span>${lopHoc.hocPhi}</span> <span class="dong">đ</span>
					</div>
					<div class="text-center">
						<span> Người học : ${lopHoc.usernameHocSinh != null ? lopHoc.usernameHocSinh: 0}
						</span>
					</div>
					<div class="btn-display">
						<button id="chuyenTrang">Đăng ký ngay</button>
					</div>
					<div class="course-info">
						<p>Mục tiêu khoá học :</p>
						<ul>
							<li>Xóa tan nỗi lo sợ học, nâng cao tinh thần tự học, rèn kĩ
								năng làm bài, cải thiện kết quả học tập của bản thân.</li>
						</ul>
						<p>Cấu trúc khoá học :</p>
						<ul>
							<li>24 bài giảng</li>
							<li>Hơn 1000 bài tập</li>
						</ul>
						<p>Dịch vụ :</p>
						<ul>
							<li>Các kênh hỗ trợ học tập</li>
							<li>Thảo luận trong từng bài giảng</li>
						</ul>
						<p>Thời gian :</p>
						<ul>
							<li>Hạn đăng ký: 18/01/2030</li>
							<li>Ngày bế giảng: ${lopHoc.ngayHoc}</li>
						</ul>
						<p>Thông tin đánh giá :</p>
						<ul>
							<li>Số sao trung bình:<%=averageRating%>
							</li>
							<li>Tổng <%=totalRatings%> đánh giá, <%
							if (userRating == 0) {
							%> bạn đã chưa giá <%
							}
							%> <%
 if (userRating != 0) {
 %> bạn đã đánh giá <%=userRating%> sao <%
 }
 %>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<%@include file="comment/coment.jsp"%>
		<div class="footer">
			<div class="wrapper-ft ">
				<div class="content-top">
					<div class="footer-block">
						<h3>VỀ HOCMAI</h3>
						<ul class="footer-block-list">
							<li><a href="">Giới thiệu</a></li>
							<li><a href="">Giáo viên nổi tiếng</a></li>
							<li><a href="">Hệ thống trung tâm HOCMAI</a></li>
							<li><a href="">Học sinh tiêu biểu</a></li>
							<li><a href="">Điều khoản chính sách</a></li>
							<li><a href="">Quy chế hoạt động</a></li>
							<li><a href="">Chính sách bảo mật thông tin</a></li>
							<li><a href="">Giải quyết khiếu nại, tranh chấp</a></li>
							<li><a href="">Tuyển dụng</a></li>
						</ul>
					</div>
					<div class="footer-block">
						<h3>DỊCH VỤ</h3>
						<ul class="footer-block-list">
							<li><a href="">Thư viện</a></li>
							<li><a href="">Ôn luyện</a></li>
							<li><a href="">Diễn đàn HOCMAI</a></li>
							<li><a href="">Speakup - Tiếng Anh 1 kèm 1 Online</a></li>
							<li><a href="">ICANTECH - Đào tạo Công nghệ & Lập trình</a></li>
						</ul>
					</div>
					<div class="footer-block">
						<h3>HỖ TRỢ KHÁCH HÀNG</h3>
						<ul class="footer-block-list">
							<li><a href="">Trung tâm hỗ trợ</a></li>
							<li><a>Email: hotro@hocmai.vn</a></li>
							<li><a>Đường dây nóng: 1900 6933</a></li>
						</ul>
					</div>
					<div class="footer-block">
						<h3>DÀNH CHO ĐỐI TÁC</h3>
						<ul class="footer-block-list">
							<li><a>Email: info@hocmai.vn</a></li>
							<li><a>Tel: +84 (24) 3519-0591</a></li>
							<li><a>Fax: +84 (24) 3519-0587</a></li>
						</ul>
					</div>
					<p id="uB" style="display: none;">${username}</p>
					<p id="liB" style="display: none;">${lopHoc.id}</p>
					<p id="llB" style="display: none;">${lopHoc.lever}</p>
					<div class="footer-block">
						<h3>TẢI ỨNG DỤNG HOCMAI</h3>
						<a href=""><img class="footer-img-app"
							src="../assets/images/footer-google-app.png"></a> <a href=""><img
							class="footer-img-app"
							src="../assets/images/footer-store-app.png"></a> <a href=""><img
							class="footer-img-app" src="../assets/images/congthuong.png"></a>
					</div>
				</div>
			</div>
			<div class="wrapper-ft">
				<div class="row">
					<div class="row-left">
						<p>
							Cơ quan chủ quản: Công ty Cổ phần Đầu tư và Dịch vụ Giáo dục <br>
							MST: 0102183602 do Sở kế hoạch và Đầu tư thành phố Hà Nội cấp
							ngày 13 tháng 03 năm 2007 <br> Địa chỉ: <br> - Văn
							phòng Hà Nội: Tầng 4, Tòa nhà 25T2, Đường Nguyễn Thị Thập, Phường
							Trung Hoà, Quận Cầu Giấy, Hà Nội. <br> - Văn phòng TP.HCM:
							13M đường số 14 khu đô thị Miếu Nổi, Phường 3, Quận Bình Thạnh,
							TP. Hồ Chí Minh <br> Hotline: 19006933 – Email:
							hotro@hocmai.vn <br> Chịu trách nhiệm nội dung: Phạm Giang
							Linh
						</p>
					</div>
					<div class="row-right"></div>
				</div>
			</div>
		</div>
	</div>

	<script>
		var username = document.getElementById('uB').textContent;
		var id_lop_hoc = document.getElementById('liB').textContent;
		var tmp = document.getElementById('llB').textContent;
		var tmp1 = "";
		if (tmp <= 5)
			tmp1 = "dangKyTieuHoc.jsp";
		else if (tmp > 5 && tmp <= 9)
			tmp1 = "dangKyTHCS.jsp";
		else
			tmp1 = "dangKyTHPT.jsp";
		var url = tmp1 + "?acc=" + encodeURIComponent(username)
				+ "&id_lop_hoc=" + encodeURIComponent(id_lop_hoc);
		document.getElementById('chuyenTrang').addEventListener('click',
				function() {
					window.location.href = url;
				});
	</script>
</body>


</html>
