<%--
  Created by IntelliJ IDEA.
  User: MinhHuyen
  Date: 9/25/2023
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="controls?action=insertCus" method="post">
        <label for="name">Full Name:</label>
        <input id="name" name="name" type="text" value="" />
        <label for="email">Email:</label>
        <input id="email" name="email" type="text" value=""/>
        <label for="phone">Email:</label>
        <input id="address" name="address" type="text" value=""/>
        <label for="address">Phone:</label>
        <input id="phone" name="phone" type="text" value=""/>
<%--        <input type="hidden" name="action" value="insert">--%>
        <input type="submit" value="insert"/>
    </form>
</body>
</html>
