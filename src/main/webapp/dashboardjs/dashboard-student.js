var requestOptions = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};
fetch("/Web_Tutor/hocsinh?actionHocSinh=list_hocsinh", requestOptions)
    .then(response => response.json())
    .then(result => getList(result))
    .catch(error => console.log('error', error));

async function getList(result) {
    var table = document.querySelector(".sub_table");

    result.forEach(function (rowData) {
        var row = document.createElement("div");
        row.className = "row";
        console.log(rowData);
        const labels = ["username", "name", "dateOfBirth", "gender", "phone", "email", "address", "bankNumber",
            "accountBalance"];

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
        viewButton.textContent = "View";
        viewButton.onclick = openModal.bind( null,rowData['username']);
        viewButtonCell.appendChild(viewButton);
        row.appendChild(viewButtonCell);
        var deleteButtonCell = document.createElement("div");
        deleteButtonCell.className = "cell";
        var deleteButton = document.createElement("button");
        deleteButton.className = "delete-button";
        deleteButton.textContent = "Delete";
        console.log('username',rowData['username']);
        deleteButton.onclick = xoaHocSinh.bind( null,rowData['username']);
        deleteButtonCell.appendChild(deleteButton);
        row.appendChild(deleteButtonCell);
        table.appendChild(row);
    });
}

async function xoaHocSinh(username) {
    var requestOptionsDelete = {
        method: 'DELETE',
        headers: {"Content-Type": "application/json"},
        redirect: 'follow'
    };
    fetch("/Web_Tutor/hocsinh?check=" + username, requestOptionsDelete)
        .then(response => response.json())
        .then(result => deleteStudent(result))
        .catch(error => console.log('error', error));
}


async function deleteStudent(result) {
    if (result['check'] == 1) {
        alert("Xóa Học Sinh Thành Công");
        location.reload()
    }
}
function openModal(rowData) {
    // Hiển thị modal
    document.getElementById("myModal").style.display = "block";

    // Gán thông tin vào các phần tử trong bảng modal
    document.getElementById("image").innerHTML = `<img src="${rowData['image']}" alt="Hình ảnh người">`;
}

function closeModal() {
    // Đóng modal
    document.getElementById("myModal").style.display = "none";
}