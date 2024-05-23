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
        <option value="">Tat ca</option>
        <c:forEach items="${dataSP}" var="s">
            <option value="${s.id}">${s.ten}</option>
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
    <th>Kích thước</th>
    <th>Màu sắc</th>
    <th>Số lượng</th>
    <th>Đơn giá</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${dataSPCT}" var="spct">
        <tr>
            <td>${spct.id}</td>
            <td>${spct.maSPCT}</td>
            <td>${spct.idKichThuoc}</td>
            <td>${spct.idMauSac}</td>
            <td>${spct.soLuong}</td>
            <td>${spct.donGia}</td>
            <td>${spct.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td>
                <a href="/spct/edit/${spct.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/spct/delete/${spct.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Hiển thị phân trang -->
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="/spct/index?idSanPham=${idSanPham}&page=${currentPage - 1}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link" href="/spct/index?idSanPham=${idSanPham}&page=${pageNum}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="/spct/index?idSanPham=${idSanPham}&page=${currentPage + 1}">Next</a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>