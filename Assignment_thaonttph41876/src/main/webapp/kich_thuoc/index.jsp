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
    Danh Sách Kích Thước
</h2>
<div class="text-end">
    <a href="/kich-thuoc/create" class="btn btn-primary">
        Add
    </a>
</div>
<table class="table table-bordered">
    <thead>
    <th>STT</th>
    <th>ID</th>
    <th>Mã</th>
    <th>Tên</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="kt" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${kt.id}</td>
            <td>${kt.ma}</td>
            <td>${kt.ten}</td>
            <td>${kt.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td>
                <a href="/kich-thuoc/edit/${kt.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/kich-thuoc/delete/${kt.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>