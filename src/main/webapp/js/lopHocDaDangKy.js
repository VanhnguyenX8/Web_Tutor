var urlParams = new URLSearchParams(window.location.search);
var acc = urlParams.get("acc");
//var acc = 'bien';
getAccount();

async function getAccount(){
	const responseAPI = await fetch("All?username=" + encodeURIComponent(acc));
	const datas = await responseAPI.json();
	
	const nd = document.getElementById("main").querySelector('table');
	var index = 1;
	datas.forEach(data => {
		
		var tr = document.createElement('tr');
		tr.innerHTML = `
			<td>${index}</td>
			<td>${data.tenLopHoc} - ${data.khoi}</td>
			<td>${data.gioHoc}:00</td>
			<td>${data.ngayHocString}</td>
			<td>${data.giasu.ten_gia_su}</td>
			<td>${data.giasu.sdt}</td>
		`;
		nd.appendChild(tr);
		index += 1;
	})
}