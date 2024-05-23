<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">
    Quản Lý Hóa Đơn
</h2>
<form action="/hoa-don/store" method="post">
    <div class="mt-3">
        <label class="form-label">Nhân viên:</label>
<%--        <input type="text" class="form-control" name="idNhanVien" value="${data.idNhanVien}">--%>
        <select name="idNhanVien" class="form-control">
            <c:forEach items="${dataNV}" var="nv">
                <option value="${nv.id}">${nv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <label class="form-label">Khách hàng:</label>
<%--        <input type="text" class="form-control" name="idKhachHang" value="${data.idKhachHang}">--%>
        <select name="idKhachHang" class="form-control">
            <c:forEach items="${dataKH}" var="kh">
                <option value="${kh.id}">${kh.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <label class="form-label">Trạng thái:</label>
        <select name="trangThai" class="form-control">
            <option value="1"
            ${data.trangThai == 1 ? "selected":""}>Đã thanh toán</option>
            <option value="0"
            ${data.trangThai == 0 ? "selected":""}>Chưa thanh toán</option>
        </select>
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Add</button>
    </div>
</form>
</body>
</html>