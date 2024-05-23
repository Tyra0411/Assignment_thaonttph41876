<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../navbar.jsp" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">Quản Lý Hóa Đơn Chi Tiết</h2>

<div class="mt-3 text-end">
    <a href="/hdct/create" class="btn btn-primary">
        Add
    </a>
</div>
    <form method="get" action="/hdct/index" class="my-3">
        <div class="input-group">
            <input type="number" name="idHoaDon" class="form-control" placeholder="Tìm kiếm theo ID hóa đơn"
                   value="${idHoaDon != null ? idHoaDon : ''}">
            <button type="submit" class="btn btn-info">Search</button>
        </div>
    </form>

<table class="table table-bordered mt-3">
    <thead>
    <th>ID</th>
    <th>ID SPCT</th>
    <th>Số lượng</th>
    <th>Đơn giá</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="hdct" varStatus="i">
        <tr>
            <td>${hdct.id}</td>
            <td>${hdct.idSPCT}</td>
            <td>${hdct.soLuong}</td>
            <td>${hdct.donGia}</td>
            <td>${hdct.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
            <td>
                <a href="/hdct/edit/${hdct.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Bạn chắc chắn muốn xóa?')" href="/hdct/delete/${hdct.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="/hdct/index?page=${currentPage - 1}&size=${size}&idHoaDon=${idHoaDon != null ? idHoaDon : ''}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link" href="/hdct/index?page=${pageNum}&size=${size}&idHoaDon=${idHoaDon != null ? idHoaDon : ''}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="/hdct/index?page=${currentPage + 1}&size=${size}&idHoaDon=${idHoaDon != null ? idHoaDon : ''}">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
