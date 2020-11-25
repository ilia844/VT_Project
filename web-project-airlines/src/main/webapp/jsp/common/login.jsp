<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static.contents/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static.contents/css/main.css">
    <title>${pageScope.title}</title>
</head>
<body class="page">
<div class="title">
    <a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-home" aria-hidden="true"></i></a>
    <h1>Login</h1>
</div>
<p class="error">${requestScope.message}</p>
<div class="wrapper_form">
    <form name="loginForm" method="POST" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="common_login"/>
        <p><label>username<input class="log_input" type="text" name="login" value=""/></label></p>
        <p><label>password<input class="log_input" type="password" name="password" value=""/></label></p>
        <input class="log_button" type="submit" value="login"/>
    </form>
</div>
<div class="reg_link">
    <span>register</span>
    <a class="reg_button" href="${pageContext.request.contextPath}/jsp/common/register.jsp">register</a>
</div>
</body>
</html>
