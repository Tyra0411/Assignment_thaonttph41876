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
    Thêm Mới Khách Hàng
</h2>
<form action="/khach-hang/store" method="post">
    <div class="mt-3">
        <label class="form-label">Mã:</label>
        <input type="text" class="form-control" name="maKH" value="${data.maKH}">
        <c:if test="${not empty errors['maKH']}">
            <small class="text-danger">
                Không để trống mã KH
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
        <label class="form-label">Số điện thoại:</label>
        <input type="text" class="form-control" name="sdt" value="${data.sdt}">
        <c:if test="${not empty errors['sdt']}">
            <small class="text-danger">
                Không để trống số điện thoại
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
        <button class="btn btn-primary">Lưu</button>
    </div>
</form>
<a href="/khach-hang/index" class="btn btn-success">Danh Sách</a>
</body>
</html>