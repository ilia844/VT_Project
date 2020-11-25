<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aircrafts</title>
</head>
<body>
<div class="table_user">
    <h1>Aircrafts</h1>
    <table>
        <tr>
            <th><span>&#8470;</span></th>
            <td>Model</td>
            <td>Seat Amount</td>
            <td>Tank Capacity</td>
        </tr>
        <c:forEach var="aircraft" items="${sessionScope.list}">
            <tr>
                <td>${aircraft.id}</td>
                <td>${aircraft.model}</td>
                <td>${aircraft.seatAmount}</td>
                <td>${aircraft.tankCapacity}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
