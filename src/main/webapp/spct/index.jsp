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
    Quản Lý Sản Phẩm Chi Tiết
</h2>
<div class="text-end my-3">
    <a href="/spct/create" class="btn btn-primary">
        Add
    </a>
</div>
<form action="/spct/index" method="get">
    <label class="form-label">Sản phẩm:</label>
    <select name="idSanPham" class="form-control">
        <option value="">Tất cả</option>
        <c:forEach items="${dataSP}" var="s">
            <option value="${s.id}" ${s.id == idSanPham ? 'selected' : ''}>${s.ten}</option>
        </c:forEach>
    </select>
    <div class="mt-3 text-end">
        <button class="btn btn-info">Search</button>
    </div>
</form>
<table class="table table-bordered mt-3">
    <thead>
    <th>ID</th>
    <th>Mã SPCT</th>
    <th>Tên Sản phẩm</th>
    <th>Kích thước</th>
    <th>Màu sắc</th>
    <th>Số lượng</th>
    <th>Đơn giá</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="spct">
        <tr>
            <td>${spct.id}</td>
            <td>${spct.maSPCT}</td>
            <td>${spct.tenSP}</td>
            <td>${spct.tenKT}</td>
            <td>${spct.tenMS}</td>
            <td>${spct.soLuong}</td>
            <td>${spct.donGia}</td>
            <td>${spct.trangThai == 1 ? "Hoạt động" : "Không hoạt động"}</td>
            <td>
                <a href="/spct/edit/${spct.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Bạn chắc chắn muốn xóa?')" href="/spct/delete/${spct.id}" class="btn btn-danger">Delete</a>
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
                    <a class="page-link" href="/spct/index?page=0&size=${size}&idSanPham=${idSanPham}" aria-label="First">
                        <span aria-hidden="true">&laquo;&laquo; First</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/spct/index?page=${currentPage - 1}&size=${size}&idSanPham=${idSanPham}" aria-label="Previous">
                        <span aria-hidden="true">&laquo; Previous</span>
                    </a>
                </li>
            </c:if>
            <li class="page-item disabled">
                <a class="page-link" href="#">Page ${currentPage + 1} of ${totalPages}</a>
            </li>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="/spct/index?page=${currentPage + 1}&size=${size}&idSanPham=${idSanPham}" aria-label="Next">
                        <span aria-hidden="true">Next &raquo;</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/spct/index?page=${totalPages - 1}&size=${size}&idSanPham=${idSanPham}" aria-label="Last">
                        <span aria-hidden="true">Last &raquo;&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>

</body>
</html>
