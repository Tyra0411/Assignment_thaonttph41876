<%@ page language="java" pageEncoding="UTF-8" %>
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
    Quản Lý Nhân Viên
</h2>
<div class="text-end my-3">
    <a href="/nhan-vien/create" class="btn btn-primary">
        Add
    </a>
</div>
<form action="/nhan-vien/search" method="get" class="mb-3"> <!-- Sửa action -->
    <div class="input-group">
        <input type="text" class="form-control" placeholder="Nhập tên nhân viên" name="keyword">
        <button type="submit" class="btn btn-info">Search</button>
    </div>
</form>

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
    <c:forEach items="${data.content}" var="nv" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${nv.id}</td>
            <td>${nv.maNV}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDangNhap}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.trangThai == 1 ? "Đang hoạt động" : "Ngưng hoạt động"}</td>
            <td>
                <a href="/nhan-vien/edit/${nv.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Bạn chắc chắn muốn xóa?')" href="/nhan-vien/delete/${nv.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation" class="mt-3">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 0}">
                <li class="page-item">
                    <a class="page-link" href="/nhan-vien/index?page=0&size=${data.size}" aria-label="First">
                        <span aria-hidden="true">&laquo;&laquo; First</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/nhan-vien/index?page=${currentPage - 1}&size=${data.size}" aria-label="Previous">
                        <span aria-hidden="true">&laquo; Previous</span>
                    </a>
                </li>
            </c:if>
            <li class="page-item disabled">
                <a class="page-link" href="#">Page ${currentPage + 1} of ${totalPages}</a>
            </li>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="/nhan-vien/index?page=${currentPage + 1}&size=${data.size}" aria-label="Next">
                        <span aria-hidden="true">Next &raquo;</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/nhan-vien/index?page=${totalPages - 1}&size=${data.size}" aria-label="Last">
                        <span aria-hidden="true">Last &raquo;&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>
