<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        /* Add background color to alternating rows for better readability */
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>

</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Status </th>
    </tr>
    </thead>
    <tbody id="employee-list">
    <!-- Employee data will be inserted here dynamically -->
    </tbody>
</table>
</body>
</html>

<script>
    function fetchAndPopulateTable() {
        const tableBody = document.getElementById("employee-list");

        // Fetch data from the API
        fetch("http://localhost:8081/week2/api/employees")
            .then(response => response.json())
            .then(data => {
                data.forEach(employee => {
                    const row = tableBody.insertRow();
                    row.insertCell(0).textContent = employee.id;
                    row.insertCell(1).textContent = employee.fullName;
                    // Convert timestamp to a readable date format
                    const dob = new Date(employee.dob).toLocaleDateString();
                    row.insertCell(2).textContent = dob;
                    row.insertCell(3).textContent = employee.email;
                    row.insertCell(4).textContent = employee.phone;
                    row.insertCell(5).textContent = employee.address;
                    row.insertCell(6).textContent = employee.status;
                });
            })
            .catch(error => {
                console.error("Error fetching data:", error);
            });
    }

    // Call the fetchAndPopulateTable function when the page loads
    window.onload = fetchAndPopulateTable;

</script>
