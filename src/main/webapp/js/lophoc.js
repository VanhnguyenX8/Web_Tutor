var requestOptions = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};
fetch("http://localhost:8080/DashBoardWeb_war_exploded/lophoc?actionLopHoc=list_lophoc", requestOptions)
    .then(response => response.json())
    .then(result => getList(result))
    .catch(error => console.log('error', error));

async function getList(result) {
    var table = document.querySelector(".sub_table");

    result.forEach(function (rowData) {
        var row = document.createElement("div");
        row.className = "row";

        const labels = ["id", "usernameStudent", "usernameTutor", "className", "classSchedule", "classDay", "tuition", "tutorFee", "description", "image"];

        labels.forEach(function (value) {
                var cell = document.createElement("div");
                cell.className = "cell";
                if (rowData[value] === 'id') {
                    cell.className = "id "
                }
                cell.textContent = rowData[value];
                row.appendChild(cell);
            }
        )
        if (rowData['accept'] === 0) {
            var denyButtonCell = document.createElement("div");
            denyButtonCell.className = "cell";
            var denyButton = document.createElement("button");
            denyButton.className = "deny-button";
            denyButton.onclick= tuChoi.bind(null, rowData);
            denyButton.textContent = "Deny";
            denyButtonCell.appendChild(denyButton);
            row.appendChild(denyButtonCell);
            var allowmentButtonCell = document.createElement("div");
            allowmentButtonCell.className = "cell";
            var allowmentButton = document.createElement("button");
            allowmentButton.className = "allow-button";
            allowmentButton.onclick= allow.bind(null, rowData);
            allowmentButton.textContent = "Allow";
            allowmentButtonCell.appendChild(allowmentButton);
            row.appendChild(allowmentButtonCell);
            table.appendChild(row);
        } else {
            var denyButtonCell = document.createElement("div");
            denyButtonCell.className = "cell";
            row.appendChild(denyButtonCell);
            var allowmentButtonCell = document.createElement("div");
            allowmentButtonCell.className = "cell";
            row.appendChild(allowmentButtonCell);
            table.appendChild(row);
        }

    });
}

async function allow(rowData) {
    const url = "http://localhost:8080/DashBoardWeb_war_exploded/lophoc?id=" + rowData.id;
    var requestOptionsPut = {
        method: 'PUT',
        headers: {"Content-Type": "application/json"},
        redirect: 'follow'
    };
    fetch(url, requestOptionsPut)
        .then(response => response.json())
        .then(result => dongY(result))
        .catch(error => console.log('error', error))
}


async function dongY(result) {
    if(result['check'] === 1){
        alert("Mở lớp thành công");
        location.reload()
    }

}

async function tuChoi(rowData) {
    const id = rowData.id;
    var requestOptions = {
        method: 'DELETE',
        headers: {"Content-Type": "application/json"},
        redirect: 'follow'
    };
    fetch("http://localhost:8080/DashBoardWeb_war_exploded/lophoc?id=" + id, requestOptions)
        .then(response => response.json())
        .then(result => denyTutor(result))
        .catch(error => console.log('error', error));
}


function denyTutor(result) {
    if(result['check'] === 1){
        alert("Xóa lớp thành công");
        location.reload()
    }
}