// Lấy tất cả các nút bằng cách sử dụng querySelectorAll
const buttons = document.querySelectorAll('.nutBacHoc');

// Lặp qua từng nút và gắn sự kiện nhấp chuột
buttons.forEach(button => {
  button.addEventListener('click', () => {
    // Xóa lớp .active khỏi tất cả các nút
    buttons.forEach(btn => btn.classList.remove('active'));

    // Thêm lớp .active vào nút được nhấp
    button.classList.add('active');
  });
});

// Lấy tất cả các nút
const buttons1 = document.getElementsByClassName('nutLop');

// Gắn sự kiện click cho từng nút
for (let i = 0; i < buttons1.length; i++) {
  buttons1[i].addEventListener('click', function() {
    // Loại bỏ lớp active khỏi tất cả các nút
    for (let j = 0; j < buttons1.length; j++) {
      buttons1[j].classList.remove('active');
    }
    
    // Thêm lớp active cho nút được ấn
    this.classList.add('active');
  });
}

// Lấy tất cả các nút
const buttons2 = document.getElementsByClassName('nutMon');

// Gắn sự kiện click cho từng nút
for (let i = 0; i < buttons2.length; i++) {
  buttons2[i].addEventListener('click', function() {
    // Loại bỏ lớp active khỏi tất cả các nút
    for (let j = 0; j < buttons2.length; j++) {
      buttons2[j].classList.remove('active');
    }
    
    // Thêm lớp active cho nút được ấn
    this.classList.add('active');
  });
}

// Lấy danh sách các nút "Chọn"
var nutChon = document.querySelectorAll('.lopHoc .chon');

// Lặp qua từng nút "Chọn"
nutChon.forEach(function(nut) {
  // Xử lý sự kiện click cho từng nút
  nut.addEventListener('click', function() {
    // Lấy thông tin lớp học từ phần tử cha của nút "Chọn"
    var lopHoc = nut.parentNode.parentNode;
    var tenLop = lopHoc.querySelector('.tenLop').textContent;
    var giaoVien = lopHoc.querySelector('.giaoVien').textContent;
    var hocPhi = lopHoc.querySelector('.hocPhi').textContent;
	nut.disabled = true;
  	nut.style.backgroundColor = 'gray';
  	nut.style.color = 'white';
    // Tạo phần tử <li> mới
    var liMoi = document.createElement('li');
    liMoi.innerHTML = `
      <div class="tenLop">${tenLop}</div>
      <div class="giaoVien">${giaoVien}</div>
      <div class="hocPhi">${hocPhi}</div>
      <div class="xoa"><a href="#">x</a></div>
    `;
	
	var hocPhiElement = document.getElementById('hocPhi');
    var hienTai = parseInt(hocPhiElement.textContent);
    var moi = hienTai + parseInt(hocPhi);
    hocPhiElement.textContent = moi + 'đ';
	
	var nutXoa = liMoi.querySelector('.xoa a');
    nutXoa.addEventListener('click', function(event) {
      event.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết
      liMoi.remove(); // Xóa phần tử <li> mới
      kiemTraDanhSachRong(); // Kiểm tra danh sách lớp học đã rỗng chưa
      nut.disabled = false;
      nut.style.backgroundColor =  '#3498db';
  	  nut.style.color = 'white';
  	  hocPhiElement = document.getElementById('hocPhi');
  	  hienTai = parseInt(hocPhiElement.textContent);
  	  moi = hienTai - parseInt(hocPhi);
  	  hocPhiElement.textContent = moi + 'đ';
    });
	
	
	
    // Thêm phần tử <li> mới vào <ul> của .lopHocDaChon
    var ulDaChon = document.querySelector('.lopHocDaChon ul');
    ulDaChon.appendChild(liMoi);

    // Ẩn thông báo "Bạn chưa chọn bất kỳ khóa học nào"
    kiemTraDanhSachRong();
  });
});

function kiemTraDanhSachRong() {
  var ulDaChon = document.querySelector('.lopHocDaChon ul');
  var thongBao = document.getElementById('chuaChonLopHoc');

  if (ulDaChon.children.length === 0) {
    thongBao.style.display = 'block';
  } else {
    thongBao.style.display = 'none';
  }
}


// Lấy phần tử div "thongBao" và nút "dangKy"
var thongBao = document.getElementById('thongBao');
var dangKyBtn = document.getElementById('dangKy');

// Gắn sự kiện click cho nút "dangKy"
dangKyBtn.addEventListener('click', function() {
  // Hiển thị div "thongBao"
  thongBao.style.display = 'block';

  // Vô hiệu hóa tương tác với các phần tử khác
  var cacPhanTuKhac = document.querySelectorAll('body > *:not(#thongBao)');
  cacPhanTuKhac.forEach(function(phanTu) {
    phanTu.classList.add('voHieu');
  });
});


// Lấy phần tử div "thongBao" và nút "dongThongBao"
var thongBao = document.getElementById('thongBao');
// Lấy danh sách các phần tử có class "dongThongBao"
var dongThongBaoBtns = document.getElementsByClassName('dongThongBao');

// Duyệt qua từng nút và gắn sự kiện click
for (var i = 0; i < dongThongBaoBtns.length; i++) {
  var dongThongBaoBtn = dongThongBaoBtns[i];
  dongThongBaoBtn.addEventListener('click', function() {
	 if (dongThongBaoBtn.parentNode.parentNode.id === "khongRong") {
	  var ulElement = document.querySelector("#thongBaoMain ul");
	
	  // Xóa tất cả nội dung trong phần tử ul
	  ulElement.innerHTML = "";
	}

	  
    // Ẩn div "thongBao"
    thongBao.style.display = 'none';

    // Hiển thị lại tương tác với các phần tử khác
    var cacPhanTuKhac = document.querySelectorAll('body > *:not(#thongBao)');
    cacPhanTuKhac.forEach(function(phanTu) {
      phanTu.classList.remove('voHieu');
    });
  });
}

// Lấy phần tử lopHocDaChon và thongBaoMain
var lopHocDaChon = document.querySelector('.lopHocDaChon');
var thongBaoMain = document.querySelector('#khongRong #thongBaoMain ul');

// Gắn sự kiện click cho nút đăng ký
var dangKyBtn = document.getElementById('dangKy');
dangKyBtn.addEventListener('click', function() {
  // Lấy danh sách các phần tử <li> trong lopHocDaChon
  var lopHocElements = lopHocDaChon.querySelectorAll('ul > li');

  // Thêm thông tin vào thongBaoMain
  lopHocElements.forEach(function(lopHocElement) {
    var tenLop = lopHocElement.querySelector('.tenLop').textContent;
    var giaoVien = lopHocElement.querySelector('.giaoVien').textContent;
    var hocPhi = lopHocElement.querySelector('.hocPhi').textContent;

    var liElement = document.createElement('li');
    liElement.innerHTML = `
      <div class="tenLop">${tenLop}</div>
      <div class="giaoVien">${giaoVien}</div>
      <div class="hocPhi">${hocPhi}</div>
    `;

    thongBaoMain.appendChild(liElement);
  });
  
  var hocPhi = document.querySelector('.lopHocDaChon #hocPhi');
  var hocPhiTmp = parseInt(hocPhi.textContent);
  var hocPhiMoi = document.querySelector('#thongBao #khongRong #thongBaoMain .tien .hocPhi .soLuong');
  hocPhiMoi.textContent = hocPhiTmp + 'đ';
  
  var soDu = document.querySelector('#thongBao #khongRong #thongBaoMain .tien .soDu .soLuong').textContent;
  var soDuTmp = parseInt(soDu);
  
  var thieu = hocPhiTmp - soDuTmp;
  if(thieu < 0) thieu = 0;
  document.querySelector('#thongBao #khongRong #thongBaoMain .tien .thieu .soLuong').textContent = thieu + 'đ';
  
  kiemTraDanhSachRong2();
  kiemTraNut();
});



function kiemTraDanhSachRong2() {
  var ulThongBaoMain = document.querySelector('#thongBaoMain ul');
  var rong = document.getElementById('rong');
  var khongRong = document.getElementById('khongRong');
  if (ulThongBaoMain.children.length === 0) {
    rong.style.display = 'block';
    khongRong.style.display = 'none';
    
  } else {
    rong.style.display = 'none';
    khongRong.style.display = 'block';
  }
}

function kiemTraNut(){
	var thieu = document.querySelector('#thongBao #khongRong #thongBaoMain .tien .thieu .soLuong').textContent;
	var thieuTmp = parseInt(thieu);
	if(thieuTmp <= 0)  {
		document.querySelector('#thongBao #khongRong #thongBaoFooter #napThemTien').style.display = 'none';
		document.querySelector('#thongBao #khongRong #thongBaoFooter #xacNhanDangKy').style.display = 'inline';
	}
	else {
		document.querySelector('#thongBao #khongRong #thongBaoFooter #napThemTien').style.display = 'inline';
		document.querySelector('#thongBao #khongRong #thongBaoFooter #xacNhanDangKy').style.display = 'none';
	}
}




























function redirectToPage(pageUrl) {
  window.location.href = pageUrl;
}

function showContent(contentId) {
  var contents = document.getElementsByClassName('class-content');
  for (var i = 0; i < contents.length; i++) {
    contents[i].classList.remove('active');
  }
  var contentToShow = document.getElementById(contentId);
  contentToShow.classList.add('active');
}

function toggleContent(contentId) {
  var contents = document.getElementsByClassName('class-content');
  for (var i = 0; i < contents.length; i++) {
    contents[i].classList.remove('active');
  }
  var contentToShow = document.getElementById(contentId);
  contentToShow.classList.add('active');
}

function showCourse(courseId) {
  var courses = document.getElementsByClassName('course-content');
  for (var i = 0; i < courses.length; i++) {
    courses[i].classList.remove('active');
  }
  var courseToShow = document.getElementById(courseId);
  courseToShow.classList.add('active');
}
