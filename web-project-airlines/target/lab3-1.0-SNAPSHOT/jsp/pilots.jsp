<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pilots</title>
</head>
<body>
<div class="table_user">
    <h1>Pilots</h1>
    <table>
        <tr>
            <th><span>&#8470;</span></th>
            <td>Name</td>
            <td>Lastname</td>
            <td>Work Experience</td>
            <td>Job Description</td>
            <td>salary</td>
        </tr>
        <c:forEach var="pilot" items="${sessionScope.list}">
            <tr>
                <td>${pilot.id}</td>
                <td>${pilot.name}</td>
                <td>${pilot.lastName}</td>
                <td>${pilot.workExperience}</td>
                <td>${pilot.jobDescription}</td>
                <td>${pilot.salary}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>