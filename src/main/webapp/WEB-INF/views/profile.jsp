<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<nav>
    <strong>PSB Portal</strong>
    <div>
        <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
        <a href="${pageContext.request.contextPath}/profile">Profile</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</nav>

<div class="card">
    <h2>Profile Details</h2>

    <div class="profile-grid">
        <div><strong>Username:</strong> ${user.username}</div>
        <div><strong>Email:</strong> ${user.email}</div>
        <div><strong>Full Name:</strong> ${person.fullName}</div>
        <div><strong>Date of Birth:</strong> ${person.dateOfBirth}</div>
        <div><strong>Gender:</strong> ${person.gender}</div>
        <div><strong>Phone:</strong> ${person.phone}</div>
        <div><strong>Country:</strong> ${person.country}</div>
        <div><strong>Department:</strong> ${person.department.departmentName}</div>
    </div>
</div>
</body>
</html>
