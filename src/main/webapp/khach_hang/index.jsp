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
<h2 class="text-center">Quản Lý Khách Hàng</h2>
<div class="mt-3 text-end">
    <a href="/khach-hang/create" class="btn btn-primary">Add</a>
</div>

<div class="my-3">
    <form method="get" action="/khach-hang/search" class="d-flex">
        <div class="input-group">
            <input type="text" name="phoneNumber" class="form-control" placeholder="Nhập số điện thoại">
            <button type="submit" class="btn btn-info">Tìm kiếm</button>
        </div>
    </form>
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
            <td>${i.index + 1}</td>
            <td>${kh.id}</td>
            <td>${kh.maKH}</td>
            <td>${kh.ten}</td>
            <td>${kh.sdt}</td>
            <td>${kh.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
            <td>
                <a href="/khach-hang/edit/${kh.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Bạn chắc chắn muốn xóa?')" href="/khach-hang/delete/${kh.id}"
                   class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Phân trang -->
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="/khach-hang/index?page=${currentPage - 1}&size=${size}&keyword=${keyword}"
                   tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link"
                       href="/khach-hang/index?page=${pageNum}&size=${size}&keyword=${keyword}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link"
                   href="/khach-hang/index?page=${currentPage + 1}&size=${size}&keyword=${keyword}">Next</a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>
