<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stewards</title>
</head>
<body>
<div class="table_user">
    <h1>Stewards</h1>
    <table>
        <tr>
            <th><span>&#8470;</span></th>
            <td>Name</td>
            <td>Lastname</td>
            <td>Work Experience</td>
            <td>Job Description</td>
            <td>salary</td>
        </tr>
        <c:forEach var="steward" items="${sessionScope.list}">
            <tr>
                <td>${steward.id}</td>
                <td>${steward.name}</td>
                <td>${steward.lastName}</td>
                <td>${steward.workExperience}</td>
                <td>${steward.jobDescription}</td>
                <td>${steward.salary}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
