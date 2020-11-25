
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="get_stewards"/>
    <input type="submit" value="stewards">
</form>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="get_pilots"/>
    <input type="submit" value="pilots">
</form>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="get_aircrafts"/>
    <input type="submit" value="aircrafts">
</form>

<span class="hello_text">${pageScope.hello_guest}</span>
<a class="logout_a"
   href="${pageContext.request.contextPath}/jsp/common/login.jsp" id="login">login</a>
<a class="register_login_a"
   href="${pageContext.request.contextPath}/jsp/common/register.jsp"
   id="register">register</a>


</body>
</html>
