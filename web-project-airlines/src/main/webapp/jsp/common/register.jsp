
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static.contents/css/main.css">
    <title>Register</title>
</head>
<body class="page">
<p class="error">${requestScope.message}</p>
<div class="reg_form">
    <form id="reg" name="RegisterForm" method="POST" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="common_register"/>

        <p><span>first name</span>
            <input id="first_name" title="first name" type="text" name="firstname" value="" placeholder="Jonson"/>
        </p>
        <p><span>last name</span>
            <input id="last_name" title="last name" type="text" name="lastname" value="" placeholder="Kidora"/>
        </p>
        <p><span>username</span>
            <input id="login" title="username" type="text" name="login" value="" placeholder="Jonson2019"/>
        </p>
        <p><span>password</span>
            <input id="password" title="password" type="password" name="password" value="" placeholder="*****"/>
        </p>
        <p><span>repeat password</span>
            <input id="confirm_password" title="confirm password" type="password" value="" placeholder="*****"/>
        </p>
        <p><span>email</span>
            <input id="email" title="email" type="text" name="email" value="" placeholder="taxi@gmail.com"/>
        </p>
        <p><span>work experience</span>
            <input id="work_experience" title="work_experience" type="text" name="work_experience" value="" placeholder="3 years"/>
        </p>
        <p><span>salary</span>
            <input id="salary" title="salary" type="text" name="salary" value="" placeholder="200 $"/>
        </p>

        <input class="reg_submit" id="submit" type="submit" value="register"/>
    </form>
</div>
</body>
</html>
