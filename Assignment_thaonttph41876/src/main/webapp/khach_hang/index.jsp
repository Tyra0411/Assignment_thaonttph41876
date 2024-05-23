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
<h2 class="text-center">Danh Sách Khách Hàng</h2>
<div class="text-end">
    <a href="/khach-hang/create" class="btn btn-primary">
        Add
    </a>
</div>
<table class="table table-bordered mt-3">
    <thead>
    <th>STT</th>
    <th>ID</th>
    <th>Mã khách hàng</th>
    <th>Tên khách hàng</th>
    <th>Số điện thoại</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="kh" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${kh.id}</td>
            <td>${kh.maKH}</td>
            <td>${kh.ten}</td>
            <td>${kh.sdt}</td>
            <td>${kh.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td>
                <a href="/khach-hang/edit/${kh.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/khach-hang/delete/${kh.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>