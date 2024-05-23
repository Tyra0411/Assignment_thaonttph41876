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
    Quản Lý Nhân Viên
</h2>
<div class="text-end">
    <a href="/nhan-vien/create" class="btn btn-primary">
        Add
    </a>
</div>
<table class="table table-bordered mt-3">
    <thead>
    <th>STT</th>
    <th>ID</th>
    <th>Mã nhân viên</th>
    <th>Tên nhân viên</th>
    <th>Tên đăng nhập</th>
    <th>Mật khẩu</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="nv" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${nv.id}</td>
            <td>${nv.maNV}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDangNhap}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td>
                <a href="/nhan-vien/edit/${nv.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/nhan-vien/delete/${nv.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>