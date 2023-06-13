var urlParams = new URLSearchParams(window.location.search);
var acc = urlParams.get("acc");

getAccount();

async function getAccount(){
	const responseAPI = await fetch("HocSinhServlet?acc=" + encodeURIComponent(acc));
	const data = await responseAPI.json();
	
	var tt = document.querySelector('#taiKhoan');
	var tt0 = tt.querySelectorAll(".hang")[0].querySelector(".giaTri");
	tt0.innerHTML = '<strong>' + data.ten_hoc_sinh + '</strong>';
	var tt1 = tt.querySelectorAll(".hang")[1].querySelector(".giaTri");
	tt1.innerHTML = '<strong>' + data.nam_sinh + '</strong>';
	var tt2 = tt.querySelectorAll(".hang")[2].querySelector(".giaTri");
	tt2.innerHTML = '<strong>' + data.sdt + '</strong>';
	var tt3 = tt.querySelectorAll(".hang")[3].querySelector(".giaTri");
	tt3.innerHTML = '<strong>' + data.email+ '</strong>';
	var tt4 = tt.querySelectorAll(".hang")[4].querySelector(".giaTri");
	tt4.innerHTML = '<strong>' + data.dia_chi + '</strong>';
	var tt5 = tt.querySelectorAll(".hang")[5].querySelector(".giaTri");
	tt5.innerHTML = '<strong>' + data.so_tai_khoan + '</strong>';
	var tt6 = tt.querySelectorAll(".hang")[6].querySelector(".giaTri");
	tt6.innerHTML = '<strong>' + data.so_du_tai_khoan + "đ" + '</strong>';
	
}

document.getElementById("quayLai").addEventListener("click", function() {
  history.back();
});