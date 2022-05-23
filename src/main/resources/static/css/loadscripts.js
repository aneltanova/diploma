function myCreateFunction() {
    var table = document.getElementById("loadTable");
    var group = document.getElementById("groups");
    var discipline = document.getElementById("disciplines");
    var department = document.getElementById("departments");

    var row = table.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);

    cell1.innerHTML = group.getAttribute();
    cell2.innerHTML = discipline.getAttribute();
    cell3.innerHTML = department.getAttribute();

    alert()
}

function myDeleteFunction() {
    document.getElementById("loadTable").deleteRow(0);
}