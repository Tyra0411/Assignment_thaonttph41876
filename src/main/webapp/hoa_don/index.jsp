<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../navbar.jsp" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">Quản Lý Hóa Đơn</h2>

<!-- Form search -->
<form action="/hoa-don/search" method="GET">
    <div class="form-group">
        <label for="trangThai">Trạng thái:</label>
        <select class="form-control" id="trangThai" name="trangThai">
            <option value="">Tất cả</option>
            <option value="1" ${trangThai == 1 ? 'selected' : ''}>Đã thanh toán</option>
            <option value="0" ${trangThai == 0 ? 'selected' : ''}>Chưa thanh toán</option>
        </select>
    </div>
    <div class="mt-3 text-end">
        <button type="submit" class="btn btn-info">Tìm kiếm</button>
    </div>
</form>

<!-- Table data -->
<table class="table table-bordered mt-3">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Nhân Viên</th>
        <th>Tên Khách Hàng</th>
        <th>Ngày Mua Hàng</th>
        <th>Trạng Thái</th>
        <th>Hoạt Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data.content}" var="hd" varStatus="i">
        <tr>
            <td>${hd.id}</td>
            <td>${hd.tenNV}</td>
            <td>${hd.tenKH}</td>
            <td>${hd.ngayMuaHang}</td>
            <td>${hd.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
            <td>
                <a href="/hoa-don/edit/${hd.id}" class="btn btn-success">Cập nhật</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Pagination -->
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation" class="mt-3">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 0}">
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=0&size=${data.size}" aria-label="First">
                        <span aria-hidden="true">&laquo;&laquo; Đầu</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=${currentPage - 1}&size=${data.size}" aria-label="Previous">
                        <span aria-hidden="true">&laquo; Trước</span>
                    </a>
                </li>
            </c:if>
            <li class="page-item disabled">
                <a class="page-link" href="#">Trang ${currentPage + 1} / ${totalPages}</a>
            </li>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=${currentPage + 1}&size=${data.size}" aria-label="Next">
                        <span aria-hidden="true">Tiếp &raquo;</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=${totalPages - 1}&size=${data.size}" aria-label="Last">
                        <span aria-hidden="true">Cuối &raquo;&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>

</body>
</html>
