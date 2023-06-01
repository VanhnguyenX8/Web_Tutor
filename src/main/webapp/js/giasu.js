var requestOptions = {
    method: 'GET',
    headers: {"Content-Type": "application/json"},
    redirect: 'follow'
};
fetch("http://localhost:8080/DashBoardWeb_war_exploded/giasu?actionGiaSu=list_giasu", requestOptions)
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
        var paymentButton = document.createElement("button");
        paymentButton.className = "pay-button";
        paymentButton.textContent = "Payment";
        paymentButton.onclick = allow.bind( null,rowData['username']);
        paymentButtonCell.appendChild(paymentButton);
        row.appendChild(paymentButtonCell);
        table.appendChild(row);
    });
}

async function allow(username) {
    var requestOptionsPut = {
        method: 'PUT',
        redirect: 'follow'
    };
    fetch("http://localhost:8080/DashBoardWeb_war_exploded/giasu?username=" + username, requestOptionsPut)
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
    fetch("http://localhost:8080/DashBoardWeb_war_exploded/giasu?username=" + username, requestOptionsDelete)
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