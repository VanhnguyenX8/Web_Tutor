const dashBoard = document.querySelector('.dashboard')
const giaSu = document.querySelector('.gia-su')
const hocSinh = document.querySelector('.hoc-sinh')
const lopHoc = document.querySelector('.lop-hoc')
const thanhToan = document.querySelector('.thanh-toan')

dashBoard.addEventListener('click', () => {
})
giaSu.addEventListener('click', () => {
    const aGiaSu = document.querySelector('.a-gia-su')
    aGiaSu.classList.add("activate")
    document.querySelector('.a-dash-board').classList.remove("activate")
    document.querySelector('.a-hoc-sinh').classList.remove("activate")
    document.querySelector('.a-lop-hoc').classList.remove("activate")
    document.querySelector('.a-thanh-toan').classList.remove("activate")
})
hocSinh.addEventListener('click', () => {
    document.querySelector('.a-hoc-sinh').classList.add("activate")
    document.querySelector('.a-dash-board').classList.remove("activate")
    document.querySelector('.a-gia-su').classList.remove("activate")
    document.querySelector('.a-lop-hoc').classList.remove("activate")
    document.querySelector('.a-thanh-toan').classList.remove("activate")
})
lopHoc.addEventListener('click', () => {
    document.querySelector('.a-lop-hoc').classList.add("activate")
    document.querySelector('.a-dash-board').classList.remove("activate")
    document.querySelector('.a-hoc-sinh').classList.remove("activate")
    document.querySelector('.a-gia-su').classList.remove("activate")
    document.querySelector('.a-thanh-toan').classList.remove("activate")
})
thanhToan.addEventListener('click', () => {
    document.querySelector('.a-thanh-toan').classList.add("activate")
    document.querySelector('.a-dash-board').classList.remove("activate")
    document.querySelector('.a-hoc-sinh').classList.remove("activate")
    document.querySelector('.a-lop-hoc').classList.remove("activate")
    document.querySelector('.a-gia-su').classList.remove("activate")
})
const ctx = document.getElementById('myChart');

new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: 'Lợi Nhuận',
            data: [12, 19, 3, 5, 2, 3],
            borderWidth: 1,
            backgroundColor: '#FCFFB2'
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true

            }
        }, maintainAspectRatio: false, responsive: true,
    }
});
const ctx2 = document.getElementById('myChart2');

new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: 'Số lượng lớp',
            data: [12, 19, 3, 5, 2, 3],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }, maintainAspectRatio: false, responsive: true,
    }
});
const data = {
    labels: [
        'Red',
        'Blue',
        'Yellow'
    ],
    datasets: [{
        label: 'My First Dataset',
        data: [300, 50, 100],
        backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
        ],
        hoverOffset: 4, maintainAspectRatio: false, responsive: true,
    }]
};
const config = {
    type: 'pie',
    data: data,
};
const pie = document.getElementById('pie');
new Chart(pie, config)