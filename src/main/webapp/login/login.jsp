<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<h2>Login</h2>
<form action="<c:url value='/login' />" method="post">
    <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" name="tenDangNhap" required>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="matKhau" required>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3">
                ${error}
        </div>
    </c:if>
</form>
</body>
</html>
