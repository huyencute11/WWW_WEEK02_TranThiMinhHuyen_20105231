<%--
  Created by IntelliJ IDEA.
  User: MinhHuyen
  Date: 10/5/2023
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <title>List Customers</title>
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
        <th>custId</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody id="customer-list">
    <!-- Employee data will be inserted here dynamically -->
    </tbody>
</table>
</body>
</html>

<script>
    function fetchAndPopulateTable() {
        const tableBody = document.getElementById("customer-list");

        // Fetch data from the API
        fetch("http://localhost:8081/Gradle___www_week2___WWW_Lab02_1_0_SNAPSHOT_war/api/customer")
            .then(response => response.json())
            .then(data => {
                data.forEach(customer => {
                    const row = tableBody.insertRow();
                    row.classList.add("table-row"); // Add a class to each row
                    row.insertCell(0).textContent = customer.custId;
                    row.insertCell(1).textContent = customer.custName;
                    // Convert timestamp to a readable date format
                    row.insertCell(2).textContent = customer.email;
                    row.insertCell(3).textContent = customer.phone;
                    row.insertCell(4).textContent = customer.address;
                });
            })
            .catch(error => {
                console.error("Error fetching data:", error);
            });
    }

    // Call the fetchAndPopulateTable function when the page loads
    window.onload = fetchAndPopulateTable;

</script>
