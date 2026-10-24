<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="auth-body">
<div class="form-container">
    <h2>Create Account</h2>

    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>

    <c:if test="${not empty message}">
        <div class="alert success">${message}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/register">
        <div class="form-grid">
            <div>
                <label>Username</label>
                <input type="text" name="username" required>
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" required>
            </div>
            <div>
                <label>Full Name</label>
                <input type="text" name="fullName" required>
            </div>
            <div>
                <label>Email</label>
                <input type="email" name="email" required>
            </div>
            <div>
                <label>Date of Birth</label>
                <input type="date" name="dateOfBirth" required>
            </div>
            <div>
                <label>Gender</label>
                <select name="gender" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div>
                <label>Phone</label>
                <input type="text" name="phone" required>
            </div>
            <div>
                <label>Nationality</label>
                <input type="text" name="nationality" required>
            </div>
            <div>
                <label>Marital Status</label>
                <input type="text" name="maritalStatus">
            </div>
            <div>
                <label>Department</label>
                <input type="text" name="departmentName" required>
            </div>
            <div>
                <label>Address</label>
                <input type="text" name="address" required>
            </div>
            <div>
                <label>City</label>
                <input type="text" name="city" required>
            </div>
            <div>
                <label>State</label>
                <input type="text" name="state" required>
            </div>
            <div>
                <label>Country</label>
                <input type="text" name="country" required>
            </div>
            <div>
                <label>Company Name</label>
                <input type="text" name="companyName" required>
            </div>
            <div>
                <label>Company Email</label>
                <input type="email" name="companyEmail" required>
            </div>
            <div>
                <label>Company Phone</label>
                <input type="text" name="companyPhone" required>
            </div>
            <div>
                <label>Company Address</label>
                <input type="text" name="companyAddress" required>
            </div>
            <div>
                <label>Company Type</label>
                <input type="text" name="companyType">
            </div>
            <div>
                <label>Website</label>
                <input type="text" name="companyWebsite">
            </div>
            <div>
                <label>Registration Number</label>
                <input type="text" name="registrationNumber">
            </div>
            <div style="grid-column: 1 / -1;">
                <label>Company Description</label>
                <textarea name="companyDescription" rows="3"></textarea>
            </div>
        </div>

        <div style="margin-top: 18px;">
            <button type="submit">Register</button>
        </div>
    </form>

    <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
</div>
</body>
</html>
