var acc = document.getElementById('acc').textContent;

document.getElementById('dangkyhocButton').addEventListener('click', function() {
    //clickButtonOption1(acc, "Tiểu học", "Lớp 2", "Toán", "Lh05");
    clickButtonOption(acc, "Tiểu học", "Lh05");
});

function clickButtonOption1(acc, str1, str2, str3, str4){
	var tmp;
	if(str1=='Tiểu học'){
		tmp = 'dangKyTieuHoc.jsp';
	}
	else if(str1=='THCS'){
		tmp = 'dangKyTieuHoc.jsp';
	}
	else{
		tmp = 'dangKyTieuHoc.jsp';
	}
	var url = tmp + "?acc=" + encodeURIComponent(acc) + 
					"&message1=" + encodeURIComponent(str2) + 
				 	"&message2=" + encodeURIComponent(str3) +
				 	"&message3=" + encodeURIComponent(str4);
				 	
	window.location.href = url;
}

function clickButtonOption(acc, str1, str2){
	var tmp;
	if(str1=='Tiểu học'){
		tmp = 'dangKyTieuHoc.jsp';
	}
	else if(str1=='THCS'){
		tmp = 'dangKyTieuHoc.jsp';
	}
	else{
		tmp = 'dangKyTieuHoc.jsp';
	}
	var url = tmp + "?acc=" + encodeURIComponent(acc) + 
					"&id_lop_hoc=" + encodeURIComponent(str2);
				 	
	window.location.href = url;
}