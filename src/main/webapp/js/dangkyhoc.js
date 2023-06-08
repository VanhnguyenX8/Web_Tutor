document.getElementById('dangkyhocButton').addEventListener('click', function() {
    clickButtonOption("Tiểu học", "Lớp 4", "Tiếng Anh", "9");
});
function clickButtonOption(str1, str2, str3, str4){
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
	var url = tmp + "?message1=" + encodeURIComponent(str2) + 
				 	"&message2=" + encodeURIComponent(str3) +
				 	"&message3=" + encodeURIComponent(str4);
	redirectToPage(url);
}
function redirectToPage(pageUrl) {
  window.location.href = pageUrl;
}