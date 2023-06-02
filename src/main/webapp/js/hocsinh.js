var requestOptions = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};
fetch("http://localhost:8080/DashBoardWeb_war_exploded/hocsinh?actionHocSinh=list_hocsinh", requestOptions)
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
    fetch("http://localhost:8080/DashBoardWeb_war_exploded/hocsinh?check=" + username, requestOptionsDelete)
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