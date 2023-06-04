const pageName = window.location.pathname.substring(window.location.pathname.lastIndexOf("/") + 1);
var urlParams = new URLSearchParams(window.location.search);
var message1 = urlParams.get("message1");
var message2 = urlParams.get("message2");
var message3 = urlParams.get("message3");

// chuyển trang
function redirectToPage(pageUrl) {
  window.location.href = pageUrl;
}

// đổi màu nút bậc học
const buttons = document.querySelectorAll('.nutBacHoc');

if(pageName == 'dangKyTieuHoc.jsp'){
		buttons[0].classList.add('active');
} 
else if(pageName == 'dangKyTHCS.jsp'){
	buttons[1].classList.add('active');
} 
else{
	buttons[2].classList.add('active');
} 

// hiển thị khối 
const khoi = document.getElementsByClassName('nhomNut')[1];
const mon = document.getElementsByClassName('nhomNut')[2];
const lop = mon.querySelector('.lopHoc');
var api;
if(pageName == 'dangKyTieuHoc.jsp'){
	api = 'http://localhost:8082/Web_Tutor/TieuHoc';
} 
else if(pageName == 'dangKyTHCS.jsp'){
	api = 'http://localhost:8082/Web_Tutor/THCS';
} 
else{
	api = 'http://localhost:8082/Web_Tutor/THPT';
} 
getKhoi();

async function getKhoi(){
	const responseAPI = await fetch(api);
	const datas = await responseAPI.json();
	const uniqueKhoiValues = new Set();
	
	datas.forEach(data => {
		const khoi = data.khoi;
		uniqueKhoiValues.add(khoi);
	})
	const firstChild = mon.firstChild;
	uniqueKhoiValues.forEach(uniKhoi => {
		const button = document.createElement('button');
		button.className = 'nutLop';
		button.textContent = "Lớp " + uniKhoi;
		khoi.appendChild(button); 
		
		// Thêm môn từng khối
		const ul = document.createElement('ul');
		ul.id = "Lớp " + uniKhoi;
		const li = document.createElement('li');
		const uniqueMonValues = new Set(); 
		
		datas.forEach(data => {
			if(data.khoi === uniKhoi){
				uniqueMonValues.add(data.tenLopHoc);
			}
		})
		uniqueMonValues.forEach(uniMon => {
			const button1 = document.createElement('button');
			button1.className = 'nutMon';
			button1.textContent = uniMon;
			li.appendChild(button1);
			
			//Thêm lớp học cho từng môn
			const ulLop = document.createElement('ul');
			ulLop.className = "Lớp " + uniKhoi + uniMon;
			
			datas.forEach(data => {
				if(data.khoi == uniKhoi && data.tenLopHoc == uniMon){
					const liLop = document.createElement('li');
					liLop.id = data.id;
					liLop.innerHTML = `
						<div class="tenLop">${uniMon} ${uniKhoi}</div>
						<div class="giaoVien">Giáo Viên: ${data.tenGiaSu}</div>
						<div class="hocPhi">${data.hocPhi}đ</div>
						<div><button class="chon">Chọn</button></div>
					`;
					ulLop.appendChild(liLop);
				}
			})
			lop.appendChild(ulLop);
			
		})
		ul.appendChild(li);
		mon.insertBefore(ul, firstChild);
	})
	
	nutKhoi();
	
	nutMon();
	
	nutChon();
	
	clickButtonDefaultKhoi();
	
	clickButtonOption(message1, message2, message3);
}

// Gán sự kiện cho các nút khối
function nutKhoi(){
	const buttons1 = document.getElementsByClassName('nutLop');
	const ulElements = mon.querySelectorAll('ul');
	
	for (let i = 0; i < buttons1.length; i++) {
	  	buttons1[i].addEventListener('click', function() {
	   	
	    for (let j = 0; j < buttons1.length; j++) {
	      buttons1[j].classList.remove('active');
	    }
	    
	    const content = this.textContent.trim();
	    
	    for(let k = 0; k < ulElements.length; k++){
			if(ulElements[k].id === content){
				ulElements[k].classList.add('active');
			}
			else{
				ulElements[k].classList.remove('active');
			}
		}
	    
	    this.classList.add('active');
	    clickButtonDefaultMon();
	  });
	}
	
}

// Gắn sự kiện cho các nút môn
function nutMon(){
	const buttons2 = document.getElementsByClassName('nutMon');
	const ulElements2 = lop.querySelectorAll('ul');
	for (let i = 0; i < buttons2.length; i++) {
	  	buttons2[i].addEventListener('click', function() {
	  	
	    for (let j = 0; j < buttons2.length; j++) {
	      buttons2[j].classList.remove('active');
	    }
	    
	    const content1 = this.parentNode.parentNode.id;
	    
		const content2 = content1 + this.textContent.trim();
		for(let k = 0; k < ulElements2.length; k++){
			ulElements2[k].classList.remove('active');
			
			if(ulElements2[k].className === content2){
				ulElements2[k].classList.add('active');
			}
		}
		
	    this.classList.add('active');
	  });
	}
}

function nutChon(){
	var nutChon = document.querySelectorAll('.lopHoc .chon');
	
	nutChon.forEach(function(nut) {
	    
	    nut.addEventListener('click', function() {
	    
	    var lopHoc = nut.parentNode.parentNode;
	    var tenLop = lopHoc.querySelector('.tenLop').textContent;
	    var giaoVien = lopHoc.querySelector('.giaoVien').textContent;
	    var hocPhi = lopHoc.querySelector('.hocPhi').textContent;
		nut.disabled = true;
	  	nut.style.backgroundColor = 'gray';
	  	nut.style.color = 'white';
	    
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
	      event.preventDefault();
	      liMoi.remove(); 
	      kiemTraDanhSachRong(); 
	      nut.disabled = false;
	      nut.style.backgroundColor =  '#3498db';
	  	  nut.style.color = 'white';
	  	  hocPhiElement = document.getElementById('hocPhi');
	  	  hienTai = parseInt(hocPhiElement.textContent);
	  	  moi = hienTai - parseInt(hocPhi);
	  	  hocPhiElement.textContent = moi + 'đ';
	    });
		
		
	    var ulDaChon = document.querySelector('.lopHocDaChon ul');
	    ulDaChon.appendChild(liMoi);
	    kiemTraDanhSachRong();
	  });
	});
}

function kiemTraDanhSachRong() {
  var ulDaChon = document.querySelector('.lopHocDaChon ul');
  var thongBao = document.getElementById('chuaChonLopHoc');

  if (ulDaChon.children.length === 0) {
    thongBao.style.display = 'block';
  } else {
    thongBao.style.display = 'none';
  }
}


// Sự kiện bấm nút đăng ký lớp học 
var thongBao = document.getElementById('thongBao');
var dangKyBtn = document.getElementById('dangKy');

dangKyBtn.addEventListener('click', function() {
  thongBao.style.display = 'block';
  var cacPhanTuKhac = document.querySelectorAll('body > *:not(#thongBao)');
  cacPhanTuKhac.forEach(function(phanTu) {
    phanTu.classList.add('voHieu');
  });
});


// Đóng thông báo
var thongBao = document.getElementById('thongBao');
var dongThongBaoBtns = document.getElementsByClassName('dongThongBao');

for (var i = 0; i < dongThongBaoBtns.length; i++) {
  	var dongThongBaoBtn = dongThongBaoBtns[i];
 	 dongThongBaoBtn.addEventListener('click', function() {
	 if (dongThongBaoBtn.parentNode.parentNode.id === "khongRong") {
	  var ulElement = document.querySelector("#thongBaoMain ul");
	
	  ulElement.innerHTML = "";
	}

    thongBao.style.display = 'none';

    var cacPhanTuKhac = document.querySelectorAll('body > *:not(#thongBao)');
    cacPhanTuKhac.forEach(function(phanTu) {
    phanTu.classList.remove('voHieu');
    });
  });
}

// Lấy các lớp đăng ký từ lớp học đã chọn
var lopHocDaChon = document.querySelector('.lopHocDaChon');
var thongBaoMain = document.querySelector('#khongRong #thongBaoMain ul');
var dangKyBtn = document.getElementById('dangKy');

dangKyBtn.addEventListener('click', function() {
  var lopHocElements = lopHocDaChon.querySelectorAll('ul > li');

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

function clickButtonDefaultKhoi(){
	var btnDf = khoi.querySelector('button');
	if(btnDf){
		btnDf.click();
	}
	
}

function clickButtonDefaultMon(){
	var btnDf2 = mon.querySelector('ul.active li button');
	if(btnDf2){
		btnDf2.click();
	}
}

function clickButtonOption(message1, message2, message3){
	
	var btns1 = khoi.querySelectorAll("button");
	var btnOp1;
	for(let i = 0; i < btns1.length; i++){
		if(btns1[i].textContent == message1){
			btnOp1 = btns1[i];
			break;
		}
	}
	btnOp1.click();
	
	var ulOp1 = mon.querySelectorAll("ul");
	var ulOp2;
	for(let i = 0; i < ulOp1.length; i++){
		if(ulOp1[i].id == message1){
			ulOp2 = ulOp1[i];
			break; 
		}
	}
	var btns2 = ulOp2.querySelectorAll("li button");
	var btnOp2;
	for(let i = 0; i < btns2.length; i++){
		if(btns2[i].textContent == message2){
			btnOp2 = btns2[i];
			break;
		}
	}
	btnOp2.click();
	
	var ulOp3 = lop.querySelectorAll("ul");
	var ulOp4;
	for(let i = 0; i < ulOp3.length; i++){
		if(ulOp3[i].className.replace(" active", "") == message1+message2){
			ulOp4 = ulOp3[i];
			break; 
		}
	}
	var lis1 = ulOp4.querySelectorAll("li");
	var liOp1;
	for(let i = 0; i < lis1.length; i++){
		if(lis1[i].id == message3){
			liOp1 = lis1[i];
			break;
		}
	}
	var btnOp3 = liOp1.querySelectorAll("div")[3].querySelector("button");
	btnOp3.click();
}