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
    Thêm Mới Nhân Viên
</h2>
<form action="/nhan-vien/store" method="post">
    <div class="mt-3">
        <label class="form-label">Mã nhân viên:</label>
        <input type="text" class="form-control" name="maNV" value="${data.maNV}">
        <c:if test="${not empty errors['maNV']}">
            <small class="text-danger">
                Không để trống mã
            </small>
        </c:if>
    </div>
    <div class="mt-3">
        <label class="form-label">Tên nhân viên:</label>
        <input type="text" class="form-control" name="ten" value="${data.ten}">
        <c:if test="${not empty errors['ten']}">
            <small class="text-danger">
                Không để trống tên
            </small>
        </c:if>
    </div>
    <div class="mt-3">
        <label class="form-label">Tên đăng nhập:</label>
        <input type="text" class="form-control" name="tenDangNhap" value="${data.tenDangNhap}">
        <c:if test="${not empty errors['tenDangNhap']}">
            <small class="text-danger">
                Không để trống tên đăng nhập
            </small>
        </c:if>
    </div>
    <div class="mt-3">
        <label class="form-label">Mật khẩu:</label>
        <input type="text" class="form-control" name="matKhau" value="${data.matKhau}">
        <c:if test="${not empty errors['matKhau']}">
            <small class="text-danger">
                Không để trống mật khẩu
            </small>
        </c:if>
    </div>
    <div class="mt-3">
        <label class="form-label">Trạng thái:</label>
        <select name="trangThai" class="form-control">
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
        <button class="btn btn-primary">Add</button>
        <a href="/nhan-vien/index" class="btn btn-success">List</a>
    </div>
</form>
</body>
</html>