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
    <c:forEach items="${data}" var="nv" varStatus="i">
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
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="/nhan-vien/index?page=${currentPage - 1}&size=${size}&keyword=${keyword}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link" href="/nhan-vien/index?page=${pageNum}&size=${size}&keyword=${param.keyword}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="/nhan-vien/index?page=${currentPage + 1}&size=${size}&keyword=${keyword}">Next</a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>
