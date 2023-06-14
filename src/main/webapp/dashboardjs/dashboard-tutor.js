const image = localStorage.getItem('image', result['image']);
const jobPosition = localStorage.getItem('jobPosition', result['jobPosition']);
const name = localStorage.getItem('name', result['name']);
const imageTag = document.querySelector('.khoiben-anh');
const jobPositionTag = document.querySelector('#vitricongviec');
const nameTag = document.querySelector('#tenadmin')
imageTag.style.backgroundImage = 'url(' + image + ')';
jobPositionTag.innerText = jobPosition;
nameTag.innerText = name;
var requestOptions = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};
fetch("/Web_Tutor/giasu?actionGiaSu=list_giasu", requestOptions)
    .then(response => response.json())
    .then(result => getList(result))
    .catch(error => console.log('error', error));

async function getList(result) {
    var table = document.querySelector(".sub_table");

    result.forEach(function (rowData) {
        var row = document.createElement("div");
        row.className = "row";

        const labels = ["username", "name", "dateOfBirth", "gender", "phone", "email", "address", "bankNumber",
            "paymentAmount", "accountBalance"];

        labels.forEach(function (value) {
                var cell = document.createElement("div");
                cell.className = "cell";
                cell.textContent = rowData[value];
                row.appendChild(cell);
            }
        )
        var viewButtonCell = document.createElement("div");
        viewButtonCell.className = "cell";
        var viewButton = document.createElement("button");
        viewButton.className = "view-button";
        viewButton.onclick= openModal.bind(null, rowData);
        viewButton.textContent = "View";
        viewButtonCell.appendChild(viewButton);
        row.appendChild(viewButtonCell);
        var deleteButtonCell = document.createElement("div");
        deleteButtonCell.className = "cell";
        var deleteButton = document.createElement("button");
        deleteButton.className = "delete-button";
        deleteButton.textContent = "Delete";
        deleteButton.onclick = tuChoi.bind(null, rowData['username']);
        deleteButtonCell.appendChild(deleteButton);
        row.appendChild(deleteButtonCell);
        var paymentButtonCell = document.createElement("div");
        paymentButtonCell.className = "cell";

        if(rowData['paymentAmount'] > 0){
            var paymentButton = document.createElement("button");
            paymentButton.className = "pay-button";
            paymentButton.textContent = "Payment";
            paymentButton.onclick = allow.bind( null,rowData['username']);
            paymentButtonCell.appendChild(paymentButton);
        }


        row.appendChild(paymentButtonCell);
        table.appendChild(row);
    });
}

async function allow(username) {
    var requestOptionsPut = {
        method: 'PUT',
        redirect: 'follow'
    };
    fetch("/Web_Tutor/giasu?username=" + username, requestOptionsPut)
        .then(response => response.json())
        .then(result => dongY(result))
        .catch(error => console.log('error', error))
}


async function dongY(result) {
    console.log("result",result)
    if(result['check'] === 1){
        alert("Mở lớp thành công");
        location.reload()
    }

}

async function tuChoi(username) {
    var requestOptionsDelete = {
        method: 'DELETE',
        redirect: 'follow'
    };
    fetch("/Web_Tutor/giasu?username=" + username, requestOptionsDelete)
        .then(response => response.json())
        .then(result => denyTutor(result))
        .catch(error => console.log('error', error));
}


function denyTutor(result) {
    console.log("result",result)
    if(result['check'] === 1){
        alert("Xóa lớp thành công");
        location.reload()
    }
}
function openModal(rowData) {
    // Hiển thị modal
    document.getElementById("myModal").style.display = "block";

    // Gán thông tin vào các phần tử trong bảng modal
    document.getElementById("image").innerHTML = '<img src='+rowData['image']+' alt="Hình ảnh người">';
}

function closeModal() {
    // Đóng modal
    document.getElementById("myModal").style.display = "none";
}