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
<h2 class="text-center">Quản Lý Hóa Đơn</h2>
<div class="text-end">
    <a href="/hoa-don/create" class="btn btn-primary">
        Add
    </a>
</div>
<table class="table table-bordered mt-3">
    <thead>
    <th>STT</th>
    <th>ID</th>
    <th>ID nhân viên</th>
    <th>ID khách hàng</th>
    <th>Ngày mua hàng</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="hd" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${hd.id}</td>
            <td>${hd.idNhanVien}</td>
            <td>${hd.idKhachHang}</td>
            <td>${hd.ngayMuaHang}</td>
            <td>${hd.trangThai == 1 ? "Da thanh toan" : "Chua thanh toan"}</td>
            <td>
                <a href="/hoa-don/edit/${hd.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/hoa-don/delete/${hd.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>