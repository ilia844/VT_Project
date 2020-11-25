
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static.contents/css/main.css">
    <title>error</title>
</head>
<body class="page">
<h1>Oops...</h1>
<p class="error_wrapper">
<p>Exception: ${pageContext.errorData.throwable}</p>
<p>Request from ${pageContext.errorData.requestURI} is failed</p>
<p>Servlet name or type: ${pageContext.errorData.servletName}</p>
<p>Status code: ${pageContext.errorData.statusCode}</p>

</body>
</html>
