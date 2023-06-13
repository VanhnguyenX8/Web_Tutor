var requestOptionsGet = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};


var requestOptions = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};
fetch("/Web_Tutor/home_dashboard?action=info_admin&username" + sessionStorage.getItem('username'), requestOptions)
    .then(response => response.json())
    .then(result => {
        const image = result['image'];
        const jobPosition = result['jobPosition'];
        const name = result['name'];
        localStorage.setItem('image',result['image'])
        localStorage.setItem('jobPosition',result['jobPosition'])
        localStorage.setItem('name',result['name'])
        const imageTag = document.querySelector('.khoiben-anh');
        const jobPositionTag = document.querySelector('#vitricongviec');
        const nameTag = document.querySelector('#tenadmin')
        imageTag.style.backgroundImage = 'url(' + image + ')';
        jobPositionTag.innerText = jobPosition;
        name.innerText = name;
    })
    .catch(error => console.log('error', error));

fetch("/Web_Tutor/home_dashboard?action=k", requestOptions)
    .then(response => response.json())
    .then(result => {
        const countHocSinh = document.querySelector("#so-luong-hoc-sinh").innerText = result['soLuongHocSinh'];
        const countGiaSu = document.getElementById("so-luong-gia-su");
        const countLopHoc = document.getElementById("so-luong-lop-hoc");
        const doanhThu = document.getElementById("doanh-thu");
        // countHocSinh.innerText = ;
        countGiaSu.innerText = result["soLuongGiaSu"];
        countLopHoc.innerText = result['soLuongLopHoc'];
        doanhThu.innerText = result['tongDoanhThu'];
    })
    .catch(error => console.log('error', error));
var currentChart;
fetch("/Web_Tutor/home_dashboard?action=loinhuan", requestOptions)
    .then(response => response.json())
    .then(result => {
        const selectElement = document.getElementById("year");
        var years = Object.keys(result[0]);
        years.forEach((year) => {
            const option = document.createElement("option");
            option.textContent = year;
            selectElement.appendChild(option);
        });
        const minYear= years[0]
        var profitByYear = Object.values(result[0][minYear]);
        var labels =Object.keys(result[0][2021]);
        var labelUpdate = [];
        labels.forEach((e)=>{
            labelUpdate.push("Tháng "+e);
        })

        // Biểu đồ lợi nhuận
        var ctx = document.getElementById('profitChart').getContext('2d');
        currentChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: labelUpdate,
                datasets: [{
                    label: 'Lợi nhuận',
                    data: profitByYear,
                    borderColor: 'blue',
                    fill: false
                }]
            },
            options: {}
        });
    })
    .catch(error => console.log('error', error));

fetch("/Web_Tutor/home_dashboard?action=tyle", requestOptions)
    .then(response => response.json())
    .then(result => {
        console.log(result)
        const data = {
            labels: [
                'Chi trả cho gia sư',
                'Lợi nhuận'
            ],
            datasets: [{
                label: 'My First Dataset',
                data: [result['phanTram'], 100 - result['phanTram']],

                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)'
                ],
                hoverOffset: 2, maintainAspectRatio: false, responsive: true,
            }]
        };
        const config = {
            type: 'pie',
            data: data,
        };
        console.log(data)
        const pie = document.getElementById('pie');
        new Chart(pie, config)
    })
    .catch(error => console.log('error', error));



function drawChart1() {
    console.log("after",currentChart)
// Hàm cập nhật biểu đồ dựa trên năm đã chọn
    fetch("/Web_Tutor/home_dashboard?action=loinhuan", requestOptions)
        .then(response => response.json())
        .then(result => {
            console.log("re",result)
            const selectElement = document.getElementById("year");
            var selectedYear = document.getElementById('year')
            var year = selectedYear.options[selectedYear.selectedIndex].text;

            var profitByYear = Object.values(result[0][year]);

            var labels =Object.keys(result[0][year]);
            var labelUpdate = [];
            labels.forEach((e)=>{
                labelUpdate.push("Tháng "+e);
            })
            console.log("la",labelUpdate)
            // Hủy biểu đồ hiện tại nếu tồn tại
            if (currentChart) {
                currentChart.destroy();
            }

            // Biểu đồ lợi nhuận
            var ctx = document.getElementById('profitChart').getContext('2d');
            currentChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labelUpdate,
                    datasets: [{
                        label: 'Lợi nhuận',
                        data: profitByYear,
                        borderColor: 'blue',
                        fill: false
                    }]
                },
                options: {}
            });
        })
        .catch(error => console.log('error', error));


}

var myChart2

fetch(`/Web_Tutor/home_dashboard?action=dangkilophoc&startDate=2023-05-30&endDate=2023-07-21`, requestOptionsGet)
    .then(response => response.json())
    .then(result => {
        const dates = [];
        const hocSinhDangKi = [];
        const soLopMo = [];
        result.forEach(item => {
            for (const date in item) {
                dates.push(date);
                hocSinhDangKi.push(item[date].hocSinhDangKi);
                soLopMo.push(item[date].soLopMo);
            }
        });
        if (myChart2) {
            myChart2.destroy();
        }
        const ctx2 = document.getElementById("myChart2")
        myChart2 = new Chart(ctx2, {
            type: 'line',
            data: {
                labels: dates,
                datasets: [
                    {
                        label: 'Số học sinh đăng ký',
                        data: hocSinhDangKi,
                        borderColor: 'rgb(75, 192, 192)',
                        fill: false
                    },
                    {
                        label: 'Số lớp được mở',
                        data: soLopMo,
                        borderColor: 'rgb(255, 99, 132)',
                        fill: false
                    }
                ], maintainAspectRatio: false, responsive: true,
            },
            options: {
                responsive: true,
                scales: {
                    x: {
                        display: true,
                        title: {
                            display: true,
                            text: 'Ngày tháng năm'
                        }
                    },
                    y: {
                        display: true,
                        title: {
                            display: true,
                            text: 'Số lượng'
                        }
                    }
                }
            }
        });
    })
    .catch(error => console.log('error', error));


function filterDate() {
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    fetch(`/Web_Tutor/home_dashboard?action=dangkilophoc&startDate=${startDate}&endDate=${endDate}`, requestOptionsGet)
        .then(response => response.json())
        .then(result => {
            const dates = [];
            const hocSinhDangKi = [];
            const soLopMo = [];
            result.forEach(item => {
                for (const date in item) {
                    dates.push(date);
                    hocSinhDangKi.push(item[date].hocSinhDangKi);
                    soLopMo.push(item[date].soLopMo);
                }
            });
            if (myChart2) {
                myChart2.destroy();
            }
            const ctx2 = document.getElementById("myChart2")
            myChart2 = new Chart(ctx2, {
                type: 'line',
                data: {
                    labels: dates,
                    datasets: [
                        {
                            label: 'Số học sinh đăng ký',
                            data: hocSinhDangKi,
                            borderColor: 'rgb(75, 192, 192)',
                            fill: false
                        },
                        {
                            label: 'Số lớp được mở',
                            data: soLopMo,
                            borderColor: 'rgb(255, 99, 132)',
                            fill: false
                        }
                    ], maintainAspectRatio: false, responsive: true,
                },
                options: {
                    responsive: true,
                    scales: {
                        x: {
                            display: true,
                            title: {
                                display: true,
                                text: 'Ngày tháng năm'
                            }
                        },
                        y: {
                            display: true,
                            title: {
                                display: true,
                                text: 'Số lượng'
                            }
                        }
                    }
                }
            });
        })
        .catch(error => console.log('error', error));


}


