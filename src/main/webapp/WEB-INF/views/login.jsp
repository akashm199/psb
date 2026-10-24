<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="auth-body">
<div class="form-container">
    <h2>Login</h2>

    <c:if test="${param.error != null}">
        <div class="alert error">Invalid username or password.</div>
    </c:if>

    <c:if test="${param.logout != null}">
        <div class="alert success">You have been logged out.</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <div>
            <label>Username or Email</label>
            <input type="text" name="username" required>
        </div>
        <div style="margin-top: 16px;">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>
        <div style="margin-top: 16px;">
            <button type="submit">Login</button>
        </div>
    </form>

    <p>New here? <a href="${pageContext.request.contextPath}/register">Create an account</a></p>
</div>
</body>
</html>
