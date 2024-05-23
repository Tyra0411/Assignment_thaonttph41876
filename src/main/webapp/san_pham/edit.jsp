<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../navbar.jsp" %>


<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">
    Chỉnh Sửa Sản Phẩm
</h2>
<div>
    <form method="post" action="/san-pham/update/${data.id}">
        <div class="mt-3">
            <label class="form-label">ID:</label>
            <input type="text" class="form-control" name="id" value="${data.id}" disabled>
        </div>
        <div class="mt-3">
            <label class="form-label">Mã:</label>
            <input type="text" class="form-control" name="ma" value="${data.ma}">
            <c:if test="${not empty errors['ma']}">
                <small class="text-danger">
                    Không để trống mã
                </small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Tên:</label>
            <input type="text" class="form-control" name="ten" value="${data.ten}">
            <c:if test="${not empty errors['ten']}">
                <small class="text-danger">
                    Không để trống tên
                </small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Trạng thái:</label>
            <select class="form-control" name="trangThai">
                <option value="1"
                ${data.trangThai == 1 ? "selected":""}>
                    Đang hoạt động
                </option>
                <option value="0"
                ${data.trangThai == 0 ? "selected":""}>
                    Ngừng hoạt động
                </option>
            </select>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary">Update</button>
            <a href="/san-pham/index" class="btn btn-success">Back</a>
        </div>
    </form>
</div>
</body>
</html>